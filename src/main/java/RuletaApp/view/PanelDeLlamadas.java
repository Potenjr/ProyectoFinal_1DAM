package RuletaApp.view;

import RuletaApp.model.RuletaModelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class PanelDeLlamadas {
	
	private final ModeloTablaLlamada tablaModelo;
	
	private final RuletaModelo modelo;
	
	private final JPanel panel;
	
	private JTable tabla;

	public PanelDeLlamadas(RuletaModelo modelo) {
		this.modelo = modelo;
		this.tablaModelo = new ModeloTablaLlamada();
		this.panel = createPanelDeLlamada();
	}
	
	private JPanel createPanelDeLlamada() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		for (int i = 0; i < 5; i++) {
			tablaModelo.addColumn("");
		}
		
		int AnchoTabla = 0;
		tabla = new JTable(tablaModelo);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setShowGrid(false);
		for (int i = 0; i < tablaModelo.getColumnCount(); i++) {
			TableColumn column = tabla.getColumnModel().getColumn(i);
			int AnchoColumna = 60;
			column.setPreferredWidth(AnchoColumna);
			AnchoTabla += AnchoColumna;
		}
		
		tabla.getColumnModel().getColumn(0).setCellRenderer(new ParesRenderer());
		tabla.getColumnModel().getColumn(1).setCellRenderer(new ColorRenderer(modelo.getColorRojo()));
		tabla.getColumnModel().getColumn(2).setCellRenderer(new VerdeRenderer(modelo.getColorVerde()));
		tabla.getColumnModel().getColumn(3).setCellRenderer(new ColorRenderer(Color.BLACK));
		tabla.getColumnModel().getColumn(4).setCellRenderer(new ImparesRenderer());

		JScrollPane PanelScroll = new JScrollPane(tabla);
		panel.add(PanelScroll, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(AnchoTabla + 50, 350));
		
		return panel;
	}
	
	public void addLlamada(String StringNumero, Color colorFondo, boolean isNegro) {
		int numero = Integer.valueOf(StringNumero);
		Object[] object = new Object[5];
		if (numero == 0) {
			object[0] = false;
			object[1] = false;
			object[2] = StringNumero;
			object[3] = false;
			object[4] = false;
		} else {
			object[0] = numero % 2 == 0;
			object[1] = !isNegro;
			object[2] = StringNumero;
			object[3] = isNegro;
			object[4] = numero % 2 != 0;
		}
		
		tablaModelo.insertRow(0, object);
		if (tablaModelo.getRowCount() > 20) {
			tablaModelo.removeRow(20);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
	
	private class ModeloTablaLlamada extends DefaultTableModel {

		private static final long serialVersionUID = 1L;

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 2:
				return String.class;
			default:
				return Boolean.class;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
		
	}
	
	private class ParesRenderer implements TableCellRenderer {
		
		private JPanel panel = new JPanel();
		
		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSelected, boolean hasFocus, int row, int column) {
			label.setHorizontalAlignment(JLabel.CENTER);
			if (value == null) {
				label.setText("");
			} else if ((Boolean) value) {
				label.setText("PAR");
			} else {
				label.setText("");
			}
			panel.add(label);
			panel.setBackground(Color.WHITE);
			
			return panel;
		}
		
	}
	
	private class ImparesRenderer implements TableCellRenderer {
		
		private JPanel panel = new JPanel();
		
		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSelected, boolean hasFocus, int row, int column) {
			label.setHorizontalAlignment(JLabel.CENTER);
			if (value == null) {
				label.setText("");
			} else if ((Boolean) value) {
				label.setText("IMPAR");
			} else {
				label.setText("");
			}
			panel.add(label);
			panel.setBackground(Color.WHITE);
			
			return panel;
		}
		
	}
	
	private class ColorRenderer implements TableCellRenderer {
		
		private Color ColorFondo;
		
		private JPanel panel = new JPanel();

		private ColorRenderer(Color colorFondo) {
			this.ColorFondo = colorFondo;
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSeleccionado, boolean hasFocus, int fila, int columna) {
			if (value == null) {
				panel.setBackground(Color.WHITE);
			} else if ((Boolean) value) {
				panel.setBackground(ColorFondo);
			} else {
				panel.setBackground(Color.WHITE);
			}
			
			return panel;
		}
	}
	
	private class VerdeRenderer implements TableCellRenderer {
		
		private Color colorFondo;
		
		private JLabel label = new JLabel();
		private JPanel panel = new JPanel();

		private VerdeRenderer(Color colorFondo) {
			this.colorFondo = colorFondo;
			this.panel.setBorder(BorderFactory.createEmptyBorder());
		}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSeleccionado, boolean hasFocus, int fila, int column) {
			String text = (String) value;
			label.setHorizontalAlignment(JLabel.CENTER);
			if (text.equals("00") || text.equals("0")) {
				panel.setBackground(colorFondo);
				label.setForeground(Color.WHITE);
			} else {
				panel.setBackground(Color.WHITE);
				label.setForeground(Color.BLACK);
			}
			label.setText(text);
			panel.add(label);
			table.setRowHeight(panel.getPreferredSize().height);
			
			return panel;
		}
	}

}
