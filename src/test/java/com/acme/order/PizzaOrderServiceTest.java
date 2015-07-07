package com.acme.order;

<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> upstream/master
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class PizzaOrderServiceTest {

	private PizzaOrderService pizzaOrderService;
	private MailSender mailSender;
	private OrderDatabase orderDatabase;
	private OrderFactory orderFactory;
	private DeliveryTimeService deliveryTimeService;
<<<<<<< HEAD
	private MessageTemplateService messageTemplateService;
=======
	private MessageTemplateService messageTemplate;
>>>>>>> upstream/master

	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
<<<<<<< HEAD
		messageTemplateService = Mockito.mock(MessageTemplateService.class);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase, orderFactory, deliveryTimeService,
				messageTemplateService);
	}

	
	
	@Test
	public void createOrderTest()
	{
		//given
		PizzaOrder pizzaOrder = givenPizzaOrder();
		PizzaType pizzaType = Mockito.mock(PizzaType.class);
		//stub
		Mockito.when(deliveryTimeService.getTime(Mockito.any(),pizzaType)).thenReturn(new Date());
	}
	
	
	@Test
	public void cancelledOrderShouldBePersistedAndEmailShouldBeSent() {
=======
		messageTemplate = Mockito.mock(MessageTemplateService.class);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase,
				orderFactory, deliveryTimeService, messageTemplate);
	}

	@Test
	public void cancelledOrderShouldBePersistedAndEmailShoudlBeSent() {
>>>>>>> upstream/master
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		// stub
<<<<<<< HEAD
		OrderCanceledTemplate template = Mockito.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(givenPizzaOrder);
		Mockito.when(messageTemplateService.getCancelTemplate()).thenReturn(template);
=======
		OrderCanceledTemplate template = Mockito
				.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(
				givenPizzaOrder);
		Mockito.when(messageTemplate.getCancelTemplate()).thenReturn(template);
>>>>>>> upstream/master
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then
		Assert.assertTrue(givenPizzaOrder.isCancelled());
<<<<<<< HEAD
		ArgumentCaptor<String> sentEmail = ArgumentCaptor.forClass(String.class);

		Mockito.verify(mailSender).send(Mockito.any(Template.class), sentEmail.capture());

		Mockito.verify(orderDatabase).save(Mockito.any(PizzaOrder.class));
	}

	private Date giveDate()
	{
		return new Date();
	}
	
=======
		ArgumentCaptor<String> sentEmailAddress = ArgumentCaptor
				.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(Template.class),
				sentEmailAddress.capture());
		Assert.assertTrue(sentEmailAddress.getValue().equals(
				givenPizzaOrder.getEmail()));

		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor
				.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());
		
		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenPizzaOrder));

	}

>>>>>>> upstream/master
	private PizzaOrder givenPizzaOrder() {
		Customer customer = givenCustomer();
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
		return givenOrder;
	}

	private Customer givenCustomer() {
<<<<<<< HEAD
		String pizzaEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}

=======
		// String customerEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}
>>>>>>> upstream/master
}
