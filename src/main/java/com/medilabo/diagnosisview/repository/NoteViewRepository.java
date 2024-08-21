package com.medilabo.diagnosisview.repository;

import com.medilabo.diagnosisview.model.NoteView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
//@FeignClient(name = "toNoteViaGateway", url = "http://localhost:8084")
@FeignClient(name = "diagnosisNote", url = "http://localhost:8083")
public interface NoteViewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/note/{id}")
    List<NoteView> findNoteByCustomId(@PathVariable("id") Long customId);

    @RequestMapping(method = RequestMethod.POST, value = "/note/add/{id}")
    void createNote(@PathVariable("id") Long customId, @RequestBody String noteField);

}