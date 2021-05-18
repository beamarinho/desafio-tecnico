package main;

import javax.swing.JOptionPane;

import model.ListaPratos;
import model.Pratos;



public class JogoGoumetMain extends javax.swing.JFrame{

	private javax.swing.JButton jBtOk;
    private javax.swing.JLabel jLabel1;
	
	
	private final Pratos massa = new Pratos("Lasanha", "massa");
	private final Pratos bolo = new Pratos("Bolo de chocolate", "");
	
	private final ListaPratos pratosMassa = new ListaPratos();
	private final ListaPratos pratoBolo = new ListaPratos();
	
	int resposta;
	
	public static void main(String ... args) {
        java.awt.EventQueue.invokeLater(() -> {
            new JogoGoumetMain().setVisible(true);
        });
    }
	
	JogoGoumetMain() {
		initJOptions();
		
		this.pratosMassa.getPratos().add(massa);
		this.pratoBolo.getPratos().add(bolo);
	}
	
	private void initJogoGourmet() {		
		resposta  = JOptionPane.showConfirmDialog(rootPane,"O prato que você pensou é massa?", "Confirm", JOptionPane.YES_NO_OPTION);
		
		if(resposta == JOptionPane.YES_OPTION) {
			// adivinha massas
			advinharPratos(pratosMassa);
			return;
		}
		// advinhar bolos
		advinharPratos(pratoBolo);
	}
	
	
	private void advinharPratos(ListaPratos pratos) {
		int cont;
		int tamLista = pratos.getPratos().size() -1;
		
		for(cont = tamLista; cont > 0; cont-- ) {
			resposta = pergunta(pratos,cont, true);
			
			if(resposta == JOptionPane.YES_OPTION) {
				resposta = pergunta(pratos,cont,false);
				
				if(resposta == JOptionPane.YES_OPTION) {
					acertou();
					break;
				}
				else if ((resposta == JOptionPane.NO_OPTION) && (cont == 0)) {
					pratoNovo(pratos, cont);
					break;
				}
			}
		}
		
		if(cont == 0) {
			resposta = pergunta(pratos, cont, false);
			
			if(resposta == JOptionPane.YES_OPTION) {
				acertou();
				return;
			}
			
			pratoNovo(pratos,cont);
			
		}
	}
	
	private int pergunta(ListaPratos pratos, int cont, boolean tipo) {
		
		if(tipo) {
			return JOptionPane.showConfirmDialog(rootPane, "O prato que pensou é ".concat(pratos.getPratos().get(cont).getTipoPrato()).concat(" ?"), "Confirm", JOptionPane.YES_NO_OPTION);
		}
		
		return JOptionPane.showConfirmDialog(rootPane, "O prato que pensou é ".concat(pratos.getPratos().get(cont).getNomePrato()).concat(" ?"), "Confirm", JOptionPane.YES_NO_OPTION);
	}
	
	private void acertou() {
		JOptionPane.showMessageDialog(rootPane, "Acertei de novo!", "Acertei", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void pratoNovo(ListaPratos pratos, int cont) {
		String nome = JOptionPane.showInputDialog(rootPane, "Qual prato você pensou ?", "Desisto", JOptionPane.QUESTION_MESSAGE);
		String tipo =JOptionPane.showInputDialog(rootPane, nome.concat(" é ________ mas ").concat(pratos.getPratos().get(cont).getNomePrato()).concat(" não."), "Complete", JOptionPane.QUESTION_MESSAGE);
	
		Pratos prato = new Pratos(nome, tipo);
		
		pratos.getPratos().add(prato);
	}
	
	
	private void initJOptions() {
		jLabel1 = new javax.swing.JLabel();
        jBtOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jogo Gourmet");

        jLabel1.setText("Pense em um prato que gosta");

        jBtOk.setText("OK");
        jBtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jBtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtOk)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
	}
	
	
	private void jBtOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOkActionPerformed
        /*Ocultando a view*/
        this.setVisible(false);
        
        /*Iniciando o jogo*/
        initJogoGourmet();
        
        /*Apresentando a view novamente*/
        this.setVisible(true);
    }
	
	
}
