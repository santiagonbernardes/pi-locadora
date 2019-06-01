package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.FormularioPadrao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControleFormularioPadrao {

	private JButton botaoSalvar;
	private JButton botaoEditar;
	private JButton botaoCancelar;
	private JButton botaoNovo;
	private JTable grid;
	private JTextField campoId;
	private List<JTextField> camposDoFormularioSemCampoId;
	private List<JComboBox> comboBoxesDoFormulario;

	public ControleFormularioPadrao(FormularioPadrao formulario) {
		this.botaoSalvar = formulario.obtenhaBotaoSalvar();
		this.botaoEditar = formulario.obtenhaBotaoEditar();
		this.botaoCancelar = formulario.obtenhaBotaoCancelar();
		this.botaoNovo = formulario.obtenhaBotaoNovo();
		this.grid = formulario.obtenhaGrid();
		this.campoId = formulario.obtenhaCampoId();
		this.camposDoFormularioSemCampoId = formulario.obtenhaCamposDoFormularioSemCampoId();
		this.comboBoxesDoFormulario = formulario.obtenhaComboBoxesDoFormulario();
	}

	public void configureFormularioParaNavegacao() {
		grid.clearSelection();
		desativeTodosOsBotoes();
		desativeTodosCamposDeTexto();
		limpeTodosOsCamposDeTexto();
		desativeTodasComboBoxes();
		limpeTodasComboBoxes();
		botaoNovo.setEnabled(true);
	}

	public void configureFormularioParaEntradaDeDados() {
		grid.clearSelection();
		limpeTodosOsCamposDeTexto();
		limpeTodasComboBoxes();
		desativeTodosOsBotoes();
		ativeTodosOsCamposTextoMenosId();
		ativeTodasComboBoxes();
		botaoSalvar.setEnabled(true);
		botaoCancelar.setEnabled(true);
	}

	public boolean confirmeApagarFormulario() {
		boolean podeModificarComponentes = true;

		if (!isFormularioVazio()) {
			int opcaoDoUsuario = JOptionPane.showConfirmDialog(null,
				"As informações do formulário serão perdidas, deseja continuar?",
				"Rent System", JOptionPane.YES_NO_OPTION);

			podeModificarComponentes = opcaoDoUsuario == JOptionPane.YES_OPTION;
		}

		if (!podeModificarComponentes) {
			botaoEditar.setEnabled(false);
			grid.clearSelection();
		}

		return podeModificarComponentes;
	}

	public void configureConformeInteracaoComGrid() {
		boolean itemSelecionadoNaLista = grid.getSelectedRowCount() == 1;
		if (itemSelecionadoNaLista) {
			botaoEditar.setEnabled(true);
		}
	}

	private void desativeTodosOsBotoes() {
		botaoNovo.setEnabled(false);
		botaoCancelar.setEnabled(false);
		botaoEditar.setEnabled(false);
		botaoSalvar.setEnabled(false);
	}

	private void desativeTodasComboBoxes() {
		for (JComboBox combobox : comboBoxesDoFormulario) {
			combobox.setEnabled(false);
		}
	}

	private void desativeTodosCamposDeTexto() {
		for(JTextField campoDeTexto : camposDoFormularioSemCampoId) {
			campoDeTexto.setEditable(false);
		}
		campoId.setEnabled(false);
	}

	private void limpeTodosOsCamposDeTexto() {
		for(JTextField campoDeTexto : camposDoFormularioSemCampoId) {
			campoDeTexto.setText("");
		}
		campoId.setText("");
	}

	private void limpeTodasComboBoxes() {
		for (JComboBox combobox : comboBoxesDoFormulario) {
			combobox.setSelectedIndex(-1);
		}
	}

	private void ativeTodosOsCamposTextoMenosId() {
		for(JTextField campoDeTexto : camposDoFormularioSemCampoId) {
			campoDeTexto.setEditable(true);
		}
	}

	private void ativeTodasComboBoxes() {
		for (JComboBox combobox : comboBoxesDoFormulario) {
			combobox.setEnabled(true);
		}
	}

	private boolean isFormularioVazio() {
		for(JTextField camposDeTexto : camposDoFormularioSemCampoId) {
			if (!camposDeTexto.getText().trim().isEmpty()) {
				return false;
			}
		}

		for (JComboBox comboBox : comboBoxesDoFormulario) {
			if (comboBox.getSelectedIndex() != -1) {
				return false;
			}
		}
		return true;
	}
}
