package com.prog3.tp1prog3;

import com.prog3.tp1prog3.Repositorios.*;
import com.prog3.tp1prog3.entidadess.*;
import com.prog3.tp1prog3.util.Estado;
import com.prog3.tp1prog3.util.FormaPago;
import com.prog3.tp1prog3.util.TipoEnvio;
import com.prog3.tp1prog3.util.TipoProducto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Builder
public class Tp1prog3Application {

	@Autowired
	FacturaRepositorio facturaRepo;

	@Autowired
	ClienteRepositorio clienteRepo;

	@Autowired
	DetallePedidoRepositorio detallePedidoRepo;

	@Autowired
	DomicilioRepositorio domicilioRepo;

	@Autowired
	PedidoRepositorio pedidoRepo;

	@Autowired
	ProductoRepositorio productoRepo;

	@Autowired
	RubroRepositorio rubroRepo;

	@Autowired
	UsuarioRepositorio usuarioRepo;

	public static void main(String[] args) {

		SpringApplication.run(Tp1prog3Application.class, args);


	}

	@Bean
	CommandLineRunner init(ClienteRepositorio clienteRepo, ConfiguracionGeneralRepositorio configuracionGeneralRepo ,PedidoRepositorio pedidoRepo, FacturaRepositorio facturaRepo, DetallePedidoRepositorio detallePedidoRepo, UsuarioRepositorio usuarioRepo, DomicilioRepositorio domicilioRepo, ProductoRepositorio productoRepo, RubroRepositorio rubroRepo){
		return args ->{
			System.out.println("Funcionando !!!!");

			System.out.println("CREANDO USUARIO");
			Usuario usuario = Usuario.builder()
					.nombre("Carlos")
					.password("carlitos")
					.rol("Analista")
					.build();

			System.out.println("CREANDO CLIENTE");
			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Filippini")
					.email("juanf@gmail.com")
					.telefono("261111111")
					.build();
			System.out.println("CREANDO PEDIDO 1");


			Pedido pedido = Pedido.builder()
					.fecha("09/09/2023")
					.estado(Estado.INICIADO)
					.horaEstimadaEntrega(LocalDateTime.now())
					.tipoEnvio(TipoEnvio.DELIVERY)
					.total(2500.00)
					.build();
			pedidoRepo.save(pedido);

			List<Pedido> pedidos = new ArrayList<Pedido>();
			pedidos.add(pedido);

			System.out.println("CREANDO PEDIDO 2");


			Pedido pedido1 = Pedido.builder()
					.fecha("11/09/2023")
					.estado(Estado.INICIADO)
					.horaEstimadaEntrega(LocalDateTime.now())
					.tipoEnvio(TipoEnvio.RETIRA)
					.total(4000.00)
					.build();
			pedidoRepo.save(pedido1);

			pedidos.add(pedido1);

			Factura factura = Factura.builder()
					.fecha(LocalDateTime.now())
					.numero(1)
					.descuento(1000.00)
					.formaPago(FormaPago.EFECTIVO)
					.total(10000)
					.build();
			facturaRepo.save(factura);

			pedido.setFactura(factura);

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(1)
					.subtotal(300.00)
					.build();
			detallePedidoRepo.save(detallePedido);

			List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
			detallePedidos.add(detallePedido);

			pedido.setDetallesPedidos(detallePedidos);

			Domicilio domicilio = Domicilio.builder()
					.calle("J.Jose Paso")
					.numero("500")
					.localidad("Carrodilla")
					.cliente(cliente)
					.build();

			Producto producto = Producto.builder()
					.tipoProducto(TipoProducto.MANUFACTURADO)
					.tiempoEstimadoCocina(5)
					.denominacion("Galletas")
					.precioVenta(600.00)
					.precioCompra(350.00)
					.stockActual(15)
					.stockMinimo(6)
					.unidadMedida("Gramos")
					.foto("Foto")
					.receta("Para galletas caseras, mezcla manteca, azúcar, huevo y vainilla. Agrega harina, sal y bicarbonato. Forma bolas, aplástalas en una bandeja y hornea a 180°C durante 10-12 minutos. ¡Listo! Galletas deliciosas y caseras en poco tiempo.")
					.build();
			productoRepo.save(producto);

			detallePedido.setProducto(producto);

			List<Producto> productos = new ArrayList<>();
			productos.add(producto);

			Rubro rubro = Rubro.builder()
					.productos(productos)
					.denominacion("Alimentos_Comida")
					.build();

			cliente.setPedidos(pedidos);
			usuario.setPedidos(pedidos);
			domicilio.setPedidos(pedidos);

			rubroRepo.save(rubro);
			clienteRepo.save(cliente);
			domicilioRepo.save(domicilio);
			usuarioRepo.save(usuario);

			ConfiguracionGeneral configGral= ConfiguracionGeneral.builder()
							.cantidadCocineros(3)
							.emailEmpresa("Galletas@Gmail.com")
									.tokenMercadoPago("Galletitas.mp")
											.build();

			configuracionGeneralRepo.save(configGral);





		};
	}

}

