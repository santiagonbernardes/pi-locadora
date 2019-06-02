package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.ControleFormularioPadrao;
import br.com.senaigo.locadora.model.Marca;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class TelaMarca extends javax.swing.JInternalFrame implements FormularioPadrao {

	private ClienteTcpController controller;
	private List<Marca> fonteDeDadosMarca;
	private ControleFormularioPadrao formulario;


	public TelaMarca() throws IOException {
		controller = new ClienteTcpController();
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
		jPanelMarca = new javax.swing.JPanel();
		jLabelID = new javax.swing.JLabel();
		jLabelNome = new javax.swing.JLabel();
		jTextFieldID = new javax.swing.JTextField();
		jTextFieldNome = new javax.swing.JTextField();
		jButtonSalvar = new javax.swing.JButton();
		jButtonCancelar = new javax.swing.JButton();
		jLabelLogoMarca = new javax.swing.JLabel();
		jButtonLogoMarca = new javax.swing.JButton();
		jScrollPaneTabela = new javax.swing.JScrollPane();
		jTableLista = new javax.swing.JTable();
		jLabelLogoSistema = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 244, 0));
		setBorder(null);

		jPanelBase.setBackground(new java.awt.Color(255, 255, 255));
		jPanelBase.setBorder(null);

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

		jPanelMarca.setBackground(new java.awt.Color(255, 255, 255));
		jPanelMarca.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Marca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

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

		jLabelLogoMarca.setBackground(new java.awt.Color(255, 203, 4));
		jLabelLogoMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		jButtonLogoMarca.setBackground(new java.awt.Color(255, 255, 255));
		jButtonLogoMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
		jButtonLogoMarca.setForeground(new java.awt.Color(0, 0, 0));
		jButtonLogoMarca.setText("Escolha a logo");
		jButtonLogoMarca.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonLogoMarcaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelMarcaLayout = new javax.swing.GroupLayout(jPanelMarca);
		jPanelMarca.setLayout(jPanelMarcaLayout);
		jPanelMarcaLayout.setHorizontalGroup(
			jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMarcaLayout.createSequentialGroup()
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jLabelNome)
							.addGap(18, 18, 18)
							.addComponent(jTextFieldNome))
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addGap(46, 46, 46)
							.addComponent(jLabelID)
							.addGap(18, 18, 18)
							.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
							.addComponent(jLabelLogoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(4, 4, 4)
							.addComponent(jButtonLogoMarca)
							.addGap(543, 543, 543))
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jPanelMarcaLayout.setVerticalGroup(
			jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMarcaLayout.createSequentialGroup()
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabelLogoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addGap(28, 28, 28)
							.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelID)
								.addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanelMarcaLayout.createSequentialGroup()
							.addGap(26, 26, 26)
							.addComponent(jButtonLogoMarca)))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jPanelMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabelNome)
						.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, Short.MAX_VALUE)
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
				"ID", "Nome", "Logo"
			}
		) {
			Class[] types = new Class[]{
				java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
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
			jTableLista.getColumnModel().getColumn(1).setPreferredWidth(830);
			jTableLista.getColumnModel().getColumn(2).setResizable(false);
			jTableLista.getColumnModel().getColumn(2).setPreferredWidth(100);
		}

		jLabelLogoSistema.setIcon(new javax.swing.ImageIcon("arquivo/imagens/logoPI.png"));

		javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
		jPanelBase.setLayout(jPanelBaseLayout);
		jPanelBaseLayout.setHorizontalGroup(
			jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelBaseLayout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseLayout.createSequentialGroup()
							.addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanelBaseLayout.createSequentialGroup()
							.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
							.addComponent(jLabelLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanelBaseLayout.setVerticalGroup(
			jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelBaseLayout.createSequentialGroup()
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jPanelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButtonNovo)
						.addComponent(jButtonEditar))
					.addGap(18, 18, Short.MAX_VALUE)
					.addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPaneTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
						.addGroup(jPanelBaseLayout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addComponent(jLabelLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
		}
	}//GEN-LAST:event_jButtonCancelarActionPerformed

	private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
		//TODO validar a entrada
		try {
			//TODO validar a entrada
			//Verificar se o campo id está preenchido. Se tiver, chamar o método que irá salvar
			String nome = jTextFieldNome.getText();
			String id = jTextFieldID.getText();
			String imagem = convertaImagemDaLabelParaString();
			Marca marca = new Marca();

			marca.setNome(nome);
			marca.setLogo(imagem);

			if (id.equals("")) {
				controller.execute(marca, Operacao.INCLUIR);
			} else {
				marca.setId(Utils.convertaParaInt(id));
				controller.execute(marca, Operacao.ALTERAR);
			}

			preenchaGrid();
			formulario.configureFormularioParaNavegacao();

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.INCLUIR + " Marca: " + erro.getMessage());
		}
	}//GEN-LAST:event_jButtonSalvarActionPerformed

	private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
		formulario.configureConformeInteracaoComGrid();
	}//GEN-LAST:event_jTableListaMouseClicked

	private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
		boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

		if (podeModificarComponentes) {
			int indexDaMarca = jTableLista.getSelectedRow();
			formulario.configureFormularioParaEntradaDeDados();
			Marca marca = fonteDeDadosMarca.get(indexDaMarca);
			jTextFieldID.setText(String.valueOf(marca.getId()));
			jTextFieldNome.setText(marca.getNome());
			ByteArrayInputStream imagemEmBytes = new ByteArrayInputStream(Base64.getDecoder().decode(marca.getLogo()));
			try {
				BufferedImage imagem = ImageIO.read(imagemEmBytes);
				jLabelLogoMarca.setIcon(new ImageIcon(imagem));
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar imagem" + erro.getMessage());
			}

		}
	}//GEN-LAST:event_jButtonEditarActionPerformed

	private void jButtonLogoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoMarcaActionPerformed
		// TODO add your handling code here:
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha a logo");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			//TODO melhorar filtro
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("png", "png");
			fileChooser.setFileFilter(filtro);
			int retorno = fileChooser.showOpenDialog(this);
			if (retorno == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				BufferedImage imagem = ImageIO.read(file);
				//TODO verificar requisitos para tratar imagens
				jLabelLogoMarca.setIcon(new ImageIcon(imagem));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler logo." + e.getMessage());
		}
	}//GEN-LAST:event_jButtonLogoMarcaActionPerformed

	private void preenchaGrid() {
		try {
			atualizeFonteDeDadosMarca();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			;
			tabela.setRowCount(0);
			for (Marca marca : fonteDeDadosMarca) {
				Object[] campos = {
					marca.getId(),
					marca.getNome()
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao " + Operacao.LISTAR.getDescricao() + " Marca: " + erro.getMessage());
		}
	}

	private void atualizeFonteDeDadosMarca() throws IOException {
		try {
			fonteDeDadosMarca = controller.liste("Marca");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro do preencher fonte de dados de marcas: " + erro.getMessage());
		}

	}

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
		camposDoFormularioSemCampoId.add(this.jTextFieldNome);

		return camposDoFormularioSemCampoId;
	}

	@Override
	public List<JComboBox> obtenhaComboBoxesDoFormulario() {
		List<JComboBox> comboBoxesDoFormulario = new ArrayList<>();
		return comboBoxesDoFormulario;
	}

	private String convertaImagemDaLabelParaString() throws IOException {
		ImageIcon icon = (ImageIcon) jLabelLogoMarca.getIcon();
		Image imagemSemTratamento = icon.getImage();
		BufferedImage imagem = (BufferedImage) imagemSemTratamento;
		ByteArrayOutputStream bytesImagem = new ByteArrayOutputStream();
		ImageIO.write(imagem, "png", bytesImagem);
		return Base64.getEncoder().encodeToString(bytesImagem.toByteArray());
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JButton jButtonLogoMarca;
	private javax.swing.JButton jButtonNovo;
	private javax.swing.JButton jButtonSalvar;
	private javax.swing.JLabel jLabelID;
	private javax.swing.JLabel jLabelLogoMarca;
	private javax.swing.JLabel jLabelLogoSistema;
	private javax.swing.JLabel jLabelNome;
	private javax.swing.JPanel jPanelBase;
	private javax.swing.JPanel jPanelMarca;
	private javax.swing.JScrollPane jScrollPaneTabela;
	private javax.swing.JTable jTableLista;
	private javax.swing.JTextField jTextFieldID;
	private javax.swing.JTextField jTextFieldNome;
	// End of variables declaration//GEN-END:variables
}
