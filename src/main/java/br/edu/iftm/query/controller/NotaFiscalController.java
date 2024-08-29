package br.edu.iftm.query.controller;

import br.edu.iftm.query.dto.NotaFiscalDTO;
import br.edu.iftm.query.service.NotaFiscalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notaFiscal")
@Tag(name = "notaFiscal", description = "Endpoint para gerenciar notas fiscais.")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping("/findById/{id}")
    @Operation(summary = "Find a notaFiscal by ID.", description = "Find a notaFiscal by ID.", tags = {
            "notaFiscal" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotaFiscalDTO.class))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public NotaFiscalDTO findById(@PathVariable Long id) {
        return notaFiscalService.findById(id);
    }

    @GetMapping("/itemsSoldWithoutDiscount")
    @Operation(summary = "find Items Sold Without Discount.", description = "find Items Sold Without Discount.", tags = { "notaFiscal" }, responses = {
            @ApiResponse(description = "Sucess.", responseCode = "200", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotaFiscalDTO.class)))
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public List<NotaFiscalDTO> findItemsSoldWithoutDiscount() {
        return notaFiscalService.findItemsSoldWithoutDiscount();
    }

    @GetMapping("/itemsSoldWithDiscount")
    @Operation(summary = "find Items Sold With Discount.", description = "find Items Sold With Discount.", tags = { "notaFiscal" }, responses = {
        @ApiResponse(description = "Sucess.", responseCode = "200", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotaFiscalDTO.class)))
        }),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
})
    public List<NotaFiscalDTO> findItemsSoldWithDiscount() {
        return notaFiscalService.findItemsSoldWithDiscount();
    }

    @GetMapping("/itemsOrderByValorUnitDesc")
    @Operation(summary = "find Items Order By Valor Unit Desc", description = "find Items Order By Valor Unit Desc", tags = { "notaFiscal" }, responses = {
        @ApiResponse(description = "Sucess.", responseCode = "200", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotaFiscalDTO.class)))
        }),
        @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
        @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
})
    public List<NotaFiscalDTO> findItemsOrderByValorUnitDesc() {
        return notaFiscalService.findItemsOrderByValorUnitDesc();
    }

    @GetMapping("/topSellingProduct")
    public List<Object[]> findTopSellingProduct() {
        return notaFiscalService.findTopSellingProduct();
    }

    @GetMapping("/nfWithMoreThan10UnitsSold")
    public List<NotaFiscalDTO> findNFWithMoreThan10UnitsSold() {
        return notaFiscalService.findNFWithMoreThan10UnitsSold();
    }

    @GetMapping("/totalNFValueGreaterThan500OrderByDesc")
    public List<Object[]> findTotalNFValueGreaterThan500OrderByDesc() {
        return notaFiscalService.findTotalNFValueGreaterThan500OrderByDesc();
    }
}