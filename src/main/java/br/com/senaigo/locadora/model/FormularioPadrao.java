package br.com.senaigo.locadora.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioPadrao {

	private JButton botaoSalvar;
	private JButton botaoEditar;
	private JButton botaoCancelar;
	private JButton botaoNovo;
	private JTable grid;
	private JTextField campoId;
	private List<JTextField> camposDoFormularioSemCampoId;
	private List<JComboBox> comboBoxesDoFormulario;

	public FormularioPadrao(JButton botaoSalvar, JButton botaoEditar, JButton botaoCancelar, JButton botaoNovo,
							JTable grid, JTextField campoId, List<JTextField> camposDoFormularioSemCampoId, List<JComboBox> comboBoxesDoFormulario) {
		this.botaoSalvar = botaoSalvar;
		this.botaoEditar = botaoEditar;
		this.botaoCancelar = botaoCancelar;
		this.botaoNovo = botaoNovo;
		this.grid = grid;
		this.campoId = campoId;
		this.camposDoFormularioSemCampoId = camposDoFormularioSemCampoId;
		this.comboBoxesDoFormulario = comboBoxesDoFormulario;
	}

	public FormularioPadrao(JButton botaoSalvar, JButton botaoEditar, JButton botaoCancelar, JButton botaoNovo, JTable grid,
							JTextField campoId, List<JTextField> camposDoFormularioSemCampoId) {
		this.botaoSalvar = botaoSalvar;
		this.botaoEditar = botaoEditar;
		this.botaoCancelar = botaoCancelar;
		this.botaoNovo = botaoNovo;
		this.grid = grid;
		this.campoId = campoId;
		this.camposDoFormularioSemCampoId = camposDoFormularioSemCampoId;
		this.comboBoxesDoFormulario = new ArrayList<>();
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
