package com.acme.order;

import java.util.Date;

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
	private MessageTemplateService messageTemplateService;

	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
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
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		// stub
		OrderCanceledTemplate template = Mockito.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(givenPizzaOrder);
		Mockito.when(messageTemplateService.getCancelTemplate()).thenReturn(template);
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then
		Assert.assertTrue(givenPizzaOrder.isCancelled());
		ArgumentCaptor<String> sentEmail = ArgumentCaptor.forClass(String.class);

		Mockito.verify(mailSender).send(Mockito.any(Template.class), sentEmail.capture());

		Mockito.verify(orderDatabase).save(Mockito.any(PizzaOrder.class));
	}

	private Date giveDate()
	{
		return new Date();
	}
	
	private PizzaOrder givenPizzaOrder() {
		Customer customer = givenCustomer();
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
		return givenOrder;
	}

	private Customer givenCustomer() {
		String pizzaEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}

}
