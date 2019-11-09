package com.co.labx.inventario.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.co.labx.inventario.service.IKardexService;

@Component
public class ScheduledStockTask {

	@Autowired
	private IKardexService kardexService;
	
	@Scheduled(cron = "${cron.expression.validation.stock}")
	public void stockTask() {
		kardexService.validarKardexVencido();
	}
	
}
