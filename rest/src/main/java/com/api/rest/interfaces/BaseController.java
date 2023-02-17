package com.api.rest.interfaces;

import com.api.rest.model.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
    public ResponseEntity<?> getAllRecords() throws Exception;
    public ResponseEntity<?> getRecordBy(Pageable pageable) throws Exception;
    public ResponseEntity<?> getRecordById(@PathVariable ID id) throws Exception;
    public ResponseEntity<?> saveRecord(@RequestBody E entity) throws Exception;
    public ResponseEntity<?> updateRecord(@PathVariable ID id,@RequestBody E entity) throws Exception;
    public ResponseEntity<?> deleteRecord(@PathVariable ID id) throws Exception;
}

