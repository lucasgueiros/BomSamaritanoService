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
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.plaf.LayerUI;
import javax.swing.text.DefaultFormatter;

/**
 * Criando a classe Campo de texto para ajudar, pode ser útil em outras classes também.
 * Ela depende de um GridBagLayout!!
 * @author lucasgueiros
 */

public class CampoComLabel {

    private JLabel label;
    private JLayer<JFormattedTextField> textField;
    private JPanel superJPanel;
    private int defaultIpadxTextField;
    private int insets = 1;

    public CampoComLabel(JPanel superJPanel, String campo, boolean obrigatorio, int defaultIpadxTextField) {
    	this(superJPanel,campo,obrigatorio,defaultIpadxTextField,null);
    }
    
    public CampoComLabel(JPanel superJPanel, String campo, boolean obrigatorio, int defaultIpadxTextField, Format format) {
        this.superJPanel = superJPanel;
        label = new JLabel(campo + (obrigatorio ? "*:" : ":"));
        
        // Criando o botão
        JFormattedTextField theTextField = null;
        if(format==null) {
        	theTextField = new JFormattedTextField();
        	/*theTextField.setFormatterFactory(new AbstractFormatterFactory() {
				
				@Override
				public AbstractFormatter getFormatter(JFormattedTextField tf) {
					return new TrueFormatter();
				}
			});*/
        } else {
        	theTextField = new JFormattedTextField(format);
        }
        
        SubclassLayerUi layerUi = new SubclassLayerUi();
        textField = new JLayer<>(theTextField,layerUi);
        
        textField.getView().setName(superJPanel.getName() + campo);
        this.defaultIpadxTextField = defaultIpadxTextField;
    }
    
    private class TrueFormatter extends JFormattedTextField.AbstractFormatter {

		@Override
		public Object stringToValue(String text) throws ParseException {
			setEditValid(false);
			return text;
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			setEditValid(false);
			if(value == null) return "";
			return value.toString();
		}
    	
    }
    
    private class SubclassLayerUi extends LayerUI<JFormattedTextField> {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -8523644548062406294L;

		@Override
    	  public void paint (Graphics g, JComponent c) {
    	    super.paint (g, c);
    	 
    	    JLayer<JFormattedTextField> jlayer = (JLayer<JFormattedTextField>)c;
    	    JFormattedTextField ftf = (JFormattedTextField)jlayer.getView();
    	    if (!ftf.isEditValid()) {
    	      Graphics2D g2 = (Graphics2D)g.create();
    	 
    	      // Paint the red X.
    	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    	          RenderingHints.VALUE_ANTIALIAS_ON);
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

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }


    public void adicionarCampoComLabel(int linha) {
        GridBagConstraints constraints = getDefault();
        constraints = setPosicao(constraints, linha, 0);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints = setPosicao(constraints, linha, 0);
        //constraints.ipadx = defaultIpadxTextField;
        superJPanel.add(this.getLabel(), constraints);

        constraints = setPosicao(getDefault(), linha, 1);
        constraints.ipadx = defaultIpadxTextField;
        superJPanel.add(textField, constraints);

        // aqui você adiciona o sistema de restrições.
    }
    
    private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna) {
        return setPosicao(constraints, linha, coluna, 1, 1);
    }

    private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna, int qtdLinhas, int qtdColunas) {
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
    Códigos úteis para outras classes
    */
    public static int getMelhorLabelSize(CampoComLabel ... ccls) {
        ArrayList<Integer> list = new ArrayList<>();
        for(CampoComLabel ccl : ccls) {
            list.add(ccl.getLabelSize());
        }
        return Collections.max(list);
    }
}