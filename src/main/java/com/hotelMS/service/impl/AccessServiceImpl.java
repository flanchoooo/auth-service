package com.hotelMS.service.impl;

import com.hotelMS.domain.Access;
import com.hotelMS.enums.ResponseDescription;
import com.hotelMS.enums.ResponseObject;
import com.hotelMS.enums.ResponseStatus;
import com.hotelMS.repository.AccessRepository;
import com.hotelMS.service.AccessService;
import com.hotelMS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    AccessRepository accessRepository;

    @Override
    public ResponseEntity<?> save(Access access) {
        Map<Object, Object> jsonResponse = new HashMap();

        if (access.getId() != null){
            access = accessRepository.findById(access.getId()).get();
            if (access== null){
                return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_NOT_FOUND.getStatus(), ResponseDescription.ENTITY_NOT_FOUND.getDescription());
            }
        }

        try {
            jsonResponse.put(Constants.PLATFORM, accessRepository.save(access));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }

    }
}
