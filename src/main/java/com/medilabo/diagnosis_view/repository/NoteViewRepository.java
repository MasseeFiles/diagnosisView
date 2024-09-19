package com.medilabo.diagnosis_view.repository;

import com.medilabo.diagnosis_view.configuration.FeignClientConfig;
import com.medilabo.diagnosis_view.model.NoteView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
@FeignClient(name = "toNoteServiceViaGateway", url = "#{toGatewayServiceUrl}", configuration = FeignClientConfig.class)
//@FeignClient(name = "toNoteService", url = "http://localhost:8083", configuration = FeignClientConfig.class)
public interface NoteViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/notes/{id}")
    List<NoteView> findNoteByCustomId(@PathVariable("id") Long customId);

    @RequestMapping(method = RequestMethod.POST, value = "/notes/{id}")
    void createNote(@PathVariable("id") Long customId, @RequestBody String noteField);

}