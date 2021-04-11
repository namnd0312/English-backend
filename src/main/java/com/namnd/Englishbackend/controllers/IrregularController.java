package com.namnd.Englishbackend.controllers;

import com.namnd.Englishbackend.dtos.IrregularVebDto;
import com.namnd.Englishbackend.services.IrregularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author nam.nd
 * @created 10/04/2021 - 11:32 PM
 */

@RestController
@RequestMapping("/api")
public class IrregularController {

    @Autowired
    private IrregularService irregularService;

    @PostMapping("/irregular/create")
    public ResponseEntity<?> saveIrregularVerb(@RequestBody IrregularVebDto dto){
        this.irregularService.create(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/irregular/{id}")
    public ResponseEntity<?> fIrregularVebDtoindById(@PathVariable("id") String id){
        IrregularVebDto irregularVebDto = this.irregularService.findById(id);

        if(irregularVebDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(irregularVebDto,HttpStatus.OK);

    }

    @DeleteMapping("/irregular/{id}")
    public ResponseEntity<?> deleteIrregularVerb(@PathVariable("id") String id){

        IrregularVebDto irregularVerb = this.irregularService.findById(id);
        if(irregularVerb == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.irregularService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/irregular/update")
    public ResponseEntity<?> updateIrregularVerb(@RequestBody IrregularVebDto dto){

        IrregularVebDto irregularVerb = this.irregularService.findById(dto.getId());
        if(irregularVerb == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.irregularService.update(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
