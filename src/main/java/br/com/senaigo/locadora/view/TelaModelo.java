package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.ControleFormularioPadrao;
import br.com.senaigo.locadora.model.Marca;
import br.com.senaigo.locadora.model.Modelo;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaModelo extends javax.swing.JInternalFrame implements FormularioPadrao {

	private ClienteTcpController controller;
	private List<Modelo> fonteDeDadosModelo;
	private List<Marca> fontedeDadosMarca;
	private ControleFormularioPadrao formulario;

	public TelaModelo() throws IOException {
		controller = new ClienteTcpController();
		atualizeFonteDeDadosMarca();
		initComponents();
		formulario = new ControleFormularioPadrao(this);
		preenchaGrid();
		formulario.configureFormularioParaNavegacao();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanelBase = new javax.swing.JPanel();
		jButtonNovo = new javax.swing.JButton();
		jButtonEditar = new javax.swing.JButton();
		jLabelLogo = new javax.swing.JLabel();
		jPanelMarca = new javax.swing.JPanel();
		jLabelID = new javax.swing.JLabel();
		jLabelNome = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jTextFieldNome = new javax.swing.JTextField();
		jButtonSalvar = new javax.swing.JButton();
		jButtonCancelar = new javax.swing.JButton();
		jLabelIcone = new javax.swing.JLabel();
		jLabelMarca = new javax.swing.JLabel();
		jComboBoxMarca = new javax.swing.JComboBox<>();
		jScrollPaneTabela = new javax.swing.JScrollPane();
		jTableLista = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 244, 0));
		setBorder(null);

		jPanelBase.setBackground(new java.awt.Color(255, 255, 255));

		jButtonNovo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jButtonNovo.setForeground(new java.awt.Color(0, 0, 0));
		jButtonNovo.setText("Novo");
		jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonNovoActionPerformed(evt);
			}
		});

		jButtonEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jButtonEditar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonEditar.setText("Editar");
		jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonEditarActionPerformed(evt);
			}
		});

		jLabelLogo.setIcon(new javax.swing.ImageIcon("arquivo/imagens/logoPI.png"));

		jPanelMarca.setBackground(new java.awt.Color(255, 255, 255));
		jPanelMarca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Modelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

		jLabelID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelID.setForeground(new java.awt.Color(0, 0, 0));
		jLabelID.setText("ID:");

		jLabelNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelNome.setForeground(new java.awt.Color(0, 0, 0));
		jLabelNome.setText("Nome:");

		jTextFieldID.setEditable(false);
		jTextFieldID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

		jTextFieldNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

		jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonSalvar.setText("Salvar");
		jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSalvarActionPerformed(evt);
			}
		});

		jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
		jButtonCancelar.setText("Cancelar");
		jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelarActionPerformed(evt);
			}
		});

		jLabelIcone.setBackground(new java.awt.Color(255, 203, 4));

		jLabelMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jLabelMarca.setForeground(new java.awt.Color(0, 0, 0));
		jLabelMarca.setText("Marca:");

		jComboBoxMarca.setModel(new DefaultComboBoxModel(fontedeDadosMarca.toArray()));

		javax.swing.GroupLayout jPanelMarcaLayout = new javax.swing.GroupLayout(jPanelMarca);
		jPanelMarca.setLayout(jPanelMarcaLayout);
		jPanelMarcaLayout.setHorizontalGroup(
			jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMarcaLayout.createSequentialGroup()
					.addGap(52, 52, 52)
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addComponent(jLabelNome)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addComponent(jLabelID)
							.addGap(18, 18, 18)
							.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabelMarca)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(331, 331, 331)))
					.addComponent(jLabelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanelMarcaLayout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelMarcaLayout.setVerticalGroup(
			jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMarcaLayout.createSequentialGroup()
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addGap(27, 27, 27)
							.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(jLabelMarca)
									.addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
									.addComponent(jLabelID)
									.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addGap(83, 83, 83)
							.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelNome))))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButtonCancelar)
						.addComponent(jButtonSalvar))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		jTableLista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jTableLista.setForeground(new java.awt.Color(0, 0, 0));
		jTableLista.setModel(new javax.swing.table.DefaultTableModel(
			new Object[][]{

			},
			new String[]{
				"ID", "Nome", "Marca"
			}
		) {
			Class[] types = new Class[]{
				java.lang.String.class, java.lang.String.class, java.lang.String.class
			};
			boolean[] canEdit = new boolean[]{
				false, false, false
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTableLista.setGridColor(new java.awt.Color(255, 255, 255));
		jTableLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jTableLista.getTableHeader().setReorderingAllowed(false);
		jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableListaMouseClicked(evt);
			}
		});
		jScrollPaneTabela.setViewportView(jTableLista);
		if (jTableLista.getColumnModel().getColumnCount() > 0) {
			jTableLista.getColumnModel().getColumn(0).setResizable(false);
			jTableLista.getColumnModel().getColumn(0).setPreferredWidth(70);
			jTableLista.getColumnModel().getColumn(1).setResizable(false);
			jTableLista.getColumnModel().getColumn(1).setPreferredWidth(465);
			jTableLista.getColumnModel().getColumn(2).setResizable(false);
			jTableLista.getColumnModel().getColumn(2).setPreferredWidth(465);
		}

		javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
		jPanelBase.setLayout(jPanelBaseLayout);
		jPanelBaseLayout.setHorizontalGroup(
			jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelBaseLayout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
							.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
							.addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jPanelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseLayout.createSequentialGroup()
							.addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelBaseLayout.setVerticalGroup(
			jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelBaseLayout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jPanelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButtonNovo)
						.addComponent(jButtonEditar))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
		formulario.configureFormularioParaEntradaDeDados();
	}//GEN-LAST:event_jButtonNovoActionPerformed

	private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

		if (podeModificarComponentes) {
			int indexDoObjeto = jTableLista.getSelectedRow();
			formulario.configureFormularioParaEntradaDeDados();
			Modelo modelo = fonteDeDadosModelo.get(indexDoObjeto);
			jTextFieldID.setText(String.valueOf(modelo.getId()));
			jTextFieldNome.setText(modelo.getNome());
			jComboBoxMarca.setSelectedItem(modelo.getMarca());
		}
	}//GEN-LAST:event_jButtonEditarActionPerformed

	private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
		try {
			//TODO popular dados aqui
			String id = jTextFieldID.getText();
			String nome = jTextFieldNome.getText();
			Marca marca = (Marca) jComboBoxMarca.getSelectedItem();

			Modelo modelo = new Modelo();
			modelo.setNome(nome);
			modelo.setMarca(marca);

			if (id.isEmpty()) {
				controller.execute(modelo, Operacao.INCLUIR);
			} else {
				modelo.setId(Utils.convertaParaInt(id));
				controller.execute(modelo, Operacao.ALTERAR);
			}
			preenchaGrid();
			formulario.configureFormularioParaNavegacao();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.INCLUIR + " Marca: " + erro.getMessage());
		}
	}//GEN-LAST:event_jButtonSalvarActionPerformed

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
		}
	}//GEN-LAST:event_jButtonCancelarActionPerformed

	private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
		formulario.configureConformeInteracaoComGrid();
	}//GEN-LAST:event_jTableListaMouseClicked

	private void preenchaGrid() {
		try {
			atualizeFonteDeDadosModelo();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			;
			tabela.setRowCount(0);
			for (Modelo modelo : fonteDeDadosModelo) {
				Object[] campos = {
					modelo.getId(),
					modelo.getNome(),
					modelo.getMarca().getNome()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.LISTAR + " Modelo: " + erro.getMessage());
		}
	}

	private void atualizeFonteDeDadosModelo() {
		try {
			fonteDeDadosModelo = controller.liste("Modelo");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro do preencher fonte de dados de modelos: " + erro.getMessage());
		}
	}

	private void atualizeFonteDeDadosMarca() {
		try {
			fontedeDadosMarca = controller.liste("Marca");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro do preencher fonte de dados de marcas: " + erro.getMessage());
		}
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JButton jButtonNovo;
	private javax.swing.JButton jButtonSalvar;
	private javax.swing.JComboBox<String> jComboBoxMarca;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelIcone;
	private javax.swing.JLabel jLabelLogo;
	private javax.swing.JLabel jLabelMarca;
	private javax.swing.JLabel jLabelNome;
	private javax.swing.JPanel jPanelBase;
	private javax.swing.JPanel jPanelMarca;
	private javax.swing.JScrollPane jScrollPaneTabela;
	private javax.swing.JTable jTableLista;
	private javax.swing.JTextField jTextFieldID;
	private javax.swing.JTextField jTextFieldNome;

	@Override
	public JButton obtenhaBotaoSalvar() {
		return this.jButtonSalvar;
	}

	@Override
	public JButton obtenhaBotaoEditar() {
		return this.jButtonEditar;
	}

	@Override
	public JButton obtenhaBotaoCancelar() {
		return this.jButtonCancelar;
	}

	@Override
	public JButton obtenhaBotaoNovo() {
		return this.jButtonNovo;
	}

	@Override
	public JTable obtenhaGrid() {
		return this.jTableLista;
	}

	@Override
	public JTextField obtenhaCampoId() {
		return this.jTextFieldID;
	}

	@Override
	public List<JTextField> obtenhaCamposDoFormularioSemCampoId() {
		List<JTextField> camposDoFormularioSemCampoId = new ArrayList<>();
		camposDoFormularioSemCampoId.add(jTextFieldNome);
		return camposDoFormularioSemCampoId;
	}

	@Override
	public List<JComboBox> obtenhaComboBoxesDoFormulario() {
		List<JComboBox> comboBoxesDoFormulario = new ArrayList<>();
		comboBoxesDoFormulario.add(jComboBoxMarca);
		return comboBoxesDoFormulario;
	}
	// End of variables declaration//GEN-END:variables
}
