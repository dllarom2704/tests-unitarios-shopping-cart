package es.iessoterohernandez.daw.endes.ejerciciosUnitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTests {
	private ShoppingCart spc;
	private Product p1, p2;

	@BeforeEach
	void setUp() throws Exception {
		spc = new ShoppingCart();
		p1 = new Product("nombreProducto1", 5);
		p2 = new Product("nombreProducto2", 10);
	}

	@Test
	public void nuevoCarro0Elementos() {
		assertEquals(0, spc.getItemCount());
	}

	@Test
	public void carroVacio0Elementos() {
		spc.empty();
		assertEquals(0, spc.getItemCount());
	}

	@Test
	public void imcrementarNumeroAñadirProducto() {
		spc.addItem(p1);
		assertEquals(1, spc.getItemCount());
	}

	@Test
	public void balanceNueevoAñadirProducto() {
		spc.addItem(p1);
		assertEquals(p1.getPrice(), spc.getBalance());
	}

	@Test
	public void decrementarNumeroEliminarProducto() {
		spc.addItem(p1);
		try {
			spc.removeItem(p1);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0, spc.getItemCount());
	}

	@Test
	public void exception() {
		try {
			spc.removeItem(p2);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
