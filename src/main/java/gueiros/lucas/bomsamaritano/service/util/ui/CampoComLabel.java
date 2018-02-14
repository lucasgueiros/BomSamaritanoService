/*
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gueiros.lucas.bomsamaritano.service.util.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.plaf.LayerUI;
import javax.swing.text.DefaultFormatterFactory;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

/**
 * Criando a classe Campo de texto para ajudar, pode ser útil em outras classes
 * também. Ela depende de um GridBagLayout!!
 * 
 * @author lucasgueiros
 */

public class CampoComLabel {

	private JLabel label;
	private JLayer<JFormattedTextField> textField;
	private JPanel superJPanel;
	private int defaultIpadxTextField;
	private int insets = 1;
	private String campo;
	private boolean obrigatorio;
	private Restricao<String> restricao;
	
	public Restricao<String> getRestricao() {
		return restricao;
	}

	public void setRestricao(Restricao<String> restricao) {
		this.restricao = restricao;
	}

	private GridBagConstraints labelConstraints = getDefault();
	private GridBagConstraints fieldConstraints = getDefault();

	public CampoComLabel(JPanel superJPanel, String campo, boolean obrigatorio, int defaultIpadxTextField) {
		this.superJPanel = superJPanel;
		this.campo = campo;
		this.obrigatorio = obrigatorio;
		this.defaultIpadxTextField = defaultIpadxTextField;
	}

	private class SubclassLayerUi extends LayerUI<JFormattedTextField> {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8523644548062406294L;

		@Override
		public void paint(Graphics g, JComponent c) {
			super.paint(g, c);

			JLayer<JFormattedTextField> jlayer = (JLayer<JFormattedTextField>) c;
			JFormattedTextField ftf = (JFormattedTextField) jlayer.getView();
			
			if (!ftf.isEditValid()) {
				Graphics2D g2 = (Graphics2D) g.create();

				// Paint the red X.
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int w = c.getWidth();
				int h = c.getHeight();
				int s = 8;
				int pad = 4;
				int x = w - pad - s;
				int y = (h - s) / 2;
				g2.setPaint(Color.red);
				g2.fillRect(x, y, s + 1, s + 1);
				g2.setPaint(Color.white);
				g2.drawLine(x, y, x + s, y + s);
				g2.drawLine(x, y + s, x + s, y);

				g2.dispose();
			}
		}
	}

	public void construirView() {
		label = new JLabel(campo + (obrigatorio ? "*:" : ":"));

		// Criando o botão
		JFormattedTextField theTextField = null;

			theTextField = new JFormattedTextField();
			theTextField.setFocusLostBehavior(JFormattedTextField.COMMIT);
			theTextField.addFocusListener(new FirstTimeFocusListener());
			theTextField.setInputVerifier(new FormattedTextFieldVerifier());
			theTextField.setFormatterFactory(new DefaultFormatterFactory(new RestricaoFormatter(restricao)));

		SubclassLayerUi layerUi = new SubclassLayerUi();
		textField = new JLayer<>(theTextField, layerUi);

		textField.getView().setName(superJPanel.getName() + campo);
		
		labelConstraints = getDefault();
		labelConstraints.anchor = GridBagConstraints.LINE_END;
		fieldConstraints = getDefault();
		fieldConstraints.ipadx = defaultIpadxTextField;
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void adicionarCampoComLabel(int linha) {
		superJPanel.add(this.getLabel(), setPosicao(labelConstraints, linha, 0));
		superJPanel.add(textField, setPosicao(fieldConstraints, linha, 1));
	}

	private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna) {
		return setPosicao(constraints, linha, coluna, 1, 1);
	}

	private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna, int qtdLinhas,
			int qtdColunas) {
		constraints.gridx = coluna; // coluna
		constraints.gridy = linha; // linha
		constraints.gridheight = qtdLinhas;
		constraints.gridwidth = qtdColunas;
		return constraints;
	}

	private GridBagConstraints getDefault() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets.bottom = constraints.insets.left = constraints.insets.right = constraints.insets.top = insets;
		constraints.anchor = GridBagConstraints.LINE_START;
		return constraints;
	}

	public int getLabelSize() {
		return label.getPreferredSize().width + (insets * 2);
	}

	public String getText() {
		return textField.getView().getText();
	}

	/*
	 * Códigos úteis para outras classes
	 */
	public static int getMelhorLabelSize(CampoComLabel... ccls) {
		ArrayList<Integer> list = new ArrayList<>();
		for (CampoComLabel ccl : ccls) {
			list.add(ccl.getLabelSize());
		}
		return Collections.max(list);
	}

	public class FirstTimeFocusListener implements FocusListener {

		private int hadFocusTimes = 0;

		@Override
		public void focusGained(FocusEvent e) {
			if (hadFocusTimes < 2)
				hadFocusTimes++;
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getSource() instanceof JFormattedTextField) {
				JFormattedTextField field = (JFormattedTextField) e.getSource();
				field.getInputVerifier().verify(field);
			}
		}

	}

	public class FormattedTextFieldVerifier extends InputVerifier {
		public boolean verify(JComponent input) {
			if (input instanceof JFormattedTextField) {
				JFormattedTextField ftf = (JFormattedTextField) input;
				AbstractFormatter formatter = ftf.getFormatter();
				if (formatter != null) {
					String text = ftf.getText();
					try {
						formatter.stringToValue(text);
						return true;
					} catch (ParseException pe) {
						return false;
					}
				}
			}
			return true;
		}

		public boolean shouldYieldFocus(JComponent input) {
			return true;
		}
	}
}
