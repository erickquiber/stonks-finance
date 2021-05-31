package com.acme.stonks.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.acme.stonks.domain.model.TermDeposit;
import com.acme.stonks.domain.service.TermDepositService;
import com.acme.stonks.resource.SaveTermDepositResource;
import com.acme.stonks.resource.TermDepositResource;

@RestController
@RequestMapping("/api")
public class TermDepositController {
	
	@Autowired TermDepositService termDepositService;
	
    @Autowired
    private ModelMapper mapper;
    
    @GetMapping("/banks/{bankId}/termdeposit")
    public Page<TermDepositResource> getAllTermsDepositsByBankId(
    		@PathVariable(value="bankId") Long bankId, Pageable pageable){
    	Page<TermDeposit> termDepositPage=termDepositService.getAllTermDepositsByBankId(bankId, pageable);
    	List<TermDepositResource> resources=termDepositPage.getContent().stream()
    			.map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    
    @GetMapping("/banks/{bankId}/termdeposit/{termdepositId}")
    public TermDepositResource getTermDepositByIdAndBankId(
    		@PathVariable(name="bankId") Long bankId,
    		@PathVariable(name="termdepositId") Long termdepositId) {
    	return convertToResource(termDepositService.getTermDepositByIdAndBankId(bankId, termdepositId));
    }
    
    @GetMapping("/comparison")
    public Page<TermDepositResource> getAllComparison(
    		@RequestParam(value="amount") float amount, 
            @RequestParam(value="days") Integer days, 
            @RequestParam(value="currency") String currency, 
            Pageable pageable){
    	Page<TermDeposit> termDepositPage=termDepositService.getAllComparison(amount,days, currency,pageable);
    	List<TermDepositResource> resources=termDepositPage.getContent().stream()
    			.map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/banks/{bankId}/termdeposit")
    public TermDepositResource createTermDeposit(
            @PathVariable(value = "bankId") Long bankId,
            @Valid @RequestBody SaveTermDepositResource resource) {
        return convertToResource(termDepositService.createTermDeposit(bankId,
                convertToEntity(resource)));
    }
    
    @PutMapping("/banks/{bankId}/termdeposit/{termdepositId}")
    public TermDepositResource updateTermDeposit(
            @PathVariable (value = "bankId") Long bankId,
            @PathVariable (value = "termdepositId") Long termdepositId,
            @Valid @RequestBody SaveTermDepositResource resource) {
        return convertToResource(termDepositService.updateTermDeposit(bankId, termdepositId,
                convertToEntity(resource)));
    }
    
    @DeleteMapping("/banks/{bankId}/termdeposit/{termdepositId}")
    public ResponseEntity<?> deleteTermDeposit(
            @PathVariable (value = "bankId") Long bankId,
            @PathVariable (value = "termdepositId") Long termdepositId) {
        return termDepositService.deleteTermDeposit(bankId, termdepositId);
    }
    
    private TermDeposit convertToEntity(SaveTermDepositResource resource) {
        return mapper.map(resource, TermDeposit.class);
    }

    private TermDepositResource convertToResource(TermDeposit entity) {
        return mapper.map(entity, TermDepositResource.class);
    }
	
}
