package com.algaworks.algafoodapi.api.v1.openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.algaworks.algafoodapi.api.v1.model.EstatisticaModel;
import com.algaworks.algafoodapi.domain.filter.VendaDiariaFilter;
import com.algaworks.algafoodapi.domain.model.insight.VendaDiaria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Estatísticas")
public interface EstatistcaControllerOpenApi {

	@ApiOperation(value = "Estatísticas", hidden = true)
	public EstatisticaModel estatisticas();

	@ApiOperation("Consulta estatísticas de vendas diárias")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "restauranteId", value = "ID do restaurante", 
                example = "1", dataType = "int"),
        @ApiImplicitParam(name = "dataCriacaoInicio", value = "Data/hora inicial da criação do pedido",
            example = "2019-12-01T00:00:00Z", dataType = "date-time"),
        @ApiImplicitParam(name = "dataCriacaoFim", value = "Data/hora final da criação do pedido",
            example = "2019-12-02T23:59:59Z", dataType = "date-time")
    })
    public List<VendaDiaria> consultarVendasDiarias(
            VendaDiariaFilter filter,
            @RequestParam(required = false, defaultValue = "+00:00") String timeOffset);

    public ResponseEntity<byte[]> consultarVendasDiariasPdf(
            VendaDiariaFilter filter,
            @RequestParam(required = false, defaultValue = "+00:00") String timeOffset);
}
