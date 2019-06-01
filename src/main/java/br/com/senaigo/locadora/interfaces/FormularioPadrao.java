package br.com.senaigo.locadora.interfaces;

import javax.swing.*;
import java.util.List;

public interface FormularioPadrao {

	JButton obtenhaBotaoSalvar();

	JButton obtenhaBotaoEditar();

	JButton obtenhaBotaoCancelar();

	JButton obtenhaBotaoNovo();

	JTable obtenhaGrid();

	JTextField obtenhaCampoId();

	List<JTextField> obtenhaCamposDoFormularioSemCampoId();

	List<JComboBox> obtenhaComboBoxesDoFormulario();
}
