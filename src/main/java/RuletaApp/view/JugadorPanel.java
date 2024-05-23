package RuletaApp.view;

import RuletaApp.controller.SeleccionJugadorListener;
import RuletaApp.model.Jugador;
import RuletaApp.model.RuletaModelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class JugadorPanel {

	private final ModeloTablaJugador modeloTabla;

	private final Color barraAzul;

	private final RuletaFrame frame;

	private final RuletaModelo modelo;

	private final JPanel panel;

	private JTable tabla;

	public JugadorPanel(RuletaFrame frame, RuletaModelo modelo) {
		this.frame = frame;
		this.modelo = modelo;
		this.barraAzul = new Color(184, 207, 229);
		this.modeloTabla = new ModeloTablaJugador();
		this.panel = createPanelJugador();
	}

	private JPanel createPanelJugador() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		String[] Columnas = {"Nombre Jugador", "Ficha jugador", "Cantidad",
				"Valor Ficha", "Cantidad actual", "Numero de fichas"
		};
		for (int i = 0; i < Columnas.length; i++) {
			modeloTabla.addColumn(Columnas[i]);
		}

		ActualizarModeloTabla();

		tabla = new JTable(modeloTabla);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.getSelectionModel().addListSelectionListener(
				new SeleccionJugadorListener(frame, modelo));

		int anchoTabla = 0;
		int[] anchoColumna = {200, 75, 75, 100, 100, 100};
		for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
			TableColumn column = tabla.getColumnModel().getColumn(i);
			column.setPreferredWidth(anchoColumna[i]);
			anchoTabla += anchoColumna[i];
		}

		tabla.getColumnModel().getColumn(0).setCellRenderer(new StringRenderer());
		tabla.getColumnModel().getColumn(1).setCellRenderer(new ImagenRenderer());
		tabla.getColumnModel().getColumn(2).setCellRenderer(new CantidadRenderer());
		tabla.getColumnModel().getColumn(3).setCellRenderer(new CantidadRenderer());
		tabla.getColumnModel().getColumn(4).setCellRenderer(new CantidadRenderer());
		tabla.getColumnModel().getColumn(5).setCellRenderer(new ContadorRenderer());

		JScrollPane scrollPane = new JScrollPane(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);

		// Crear un espacio en blanco en la parte inferior para mover el panel hacia abajo
		JPanel PanelVacio = new JPanel();
		PanelVacio.setPreferredSize(new Dimension(anchoTabla + 50, -150));
		panel.add(PanelVacio, BorderLayout.SOUTH);

		return panel;
	}

	public void ActualizarModeloTabla() {
		modeloTabla.setRowCount(0);
		for (Jugador jugador : modelo.getJugador()) {
			addJugador(jugador);
		}

	}

	private void addJugador(Jugador jugador) {
		Object[] object = new Object[6];
		object[0] = jugador.getNombre();
		object[1] = jugador.getImagenFicha();
		object[2] = jugador.getCantidadCompra();
		object[3] = jugador.getValorFicha();
		object[4] = jugador.getBalance();
		object[5] = jugador.getContadorFicha();

		modeloTabla.addRow(object);
	}

	public JPanel getPanel() {
		return panel;
	}

	public JTable getTabla() {
		return tabla;
	}

	private class ModeloTablaJugador extends DefaultTableModel {

		private static final long serialVersionUID = 1L;

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
				case 0:
					return String.class;
				case 1:
					return BufferedImage.class;
				default:
					return Integer.class;
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

	}

	private class ImagenRenderer implements TableCellRenderer {

		private JPanel panel = new JPanel();

		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
													   boolean isSelected, boolean hasFocus, int row, int column) {
			label.setIcon(new ImageIcon((BufferedImage) value));
			panel.add(label);
			if (isSelected) {
				panel.setBackground(barraAzul);
			} else {
				panel.setBackground(Color.WHITE);
			}
			table.setRowHeight(panel.getPreferredSize().height);
			return panel;
		}

	}

	private class ContadorRenderer implements TableCellRenderer {

		private JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
													   boolean isSeleccionado, boolean hasFocus, int row, int column) {
			label.setHorizontalAlignment(JLabel.TRAILING);
			label.setText(String.format("%,d", (Integer) value));
			panel.add(label);
			if (isSeleccionado) {
				panel.setBackground(barraAzul);
			} else {
				panel.setBackground(Color.WHITE);
			}
			return panel;
		}

	}

	private class CantidadRenderer implements TableCellRenderer {

		private JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 5));

		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
													   boolean isSeleccionado, boolean hasFocus, int fila, int columna) {
			label.setHorizontalAlignment(JLabel.TRAILING);
			label.setText("$" + String.format("%,d", (Integer) value) + ".00");
			panel.add(label);
			if (isSeleccionado) {
				panel.setBackground(barraAzul);
			} else {
				panel.setBackground(Color.WHITE);
			}
			return panel;
		}

	}

	private class StringRenderer implements TableCellRenderer {

		private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));

		private JLabel label = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
													   boolean isSeleccionado, boolean hasFocus, int fila, int columna) {
			label.setText((String) value);
			panel.add(label);
			if (isSeleccionado) {
				panel.setBackground(barraAzul);
			} else {
				panel.setBackground(Color.WHITE);
			}
			return panel;
		}

	}

}
