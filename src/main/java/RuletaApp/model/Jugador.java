package RuletaApp.model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Jugador {
	
	private int balance;
	private int CantidadCompra;
	private int ContadorFicha;
	
	private ValorFicha ValorFicha;
	
	private FichaRuleta FichaRuleta;
	
	private final String nombre;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public void compra(int CantidadCompra, ValorFicha ValorFicha) {
		this.CantidadCompra = CantidadCompra;
		this.balance = CantidadCompra;
		this.ValorFicha = ValorFicha;
		this.ContadorFicha = CantidadCompra / getValorFicha();
	}
	
	public void EliminarFicha(int cantidad) {
		this.ContadorFicha -= cantidad;
		this.balance -= cantidad * getValorFicha();
	}
	
	public void addFichas(int cantidad) {
		this.ContadorFicha += cantidad;
		this.balance += cantidad * getValorFicha();
	}

	public FichaRuleta getFichaRuleta() {
		return FichaRuleta;
	}

	public void setFichaRuleta(RuletaApp.model.FichaRuleta FichaRuleta) {
		this.FichaRuleta = FichaRuleta;
	}

	public int getBalance() {
		return balance;
	}

	public int getCantidadCompra() {
		return CantidadCompra;
	}

	public int getContadorFicha() {
		return ContadorFicha;
	}

	public int getValorFicha() {
		return ValorFicha.getValor();
	}

	public Color getChipColor() {
		return FichaRuleta.getColorFicha();
	}

	public BufferedImage getImagenFicha() {
		return FichaRuleta.getImagenFicha();
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jugador [nombre=");
		builder.append(nombre);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", Cantidad comprada=");
		builder.append(CantidadCompra);
		builder.append(", Contador de Fichas=");
		builder.append(ContadorFicha);
		builder.append(", Valor de Fichas=");
		builder.append(ValorFicha);
		builder.append("]");
		return builder.toString();
	}

}
