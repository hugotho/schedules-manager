package br.ufrn.residenciaimd.schedulemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.residenciaimd.schedulemanager.entities.Trial;
import br.ufrn.residenciaimd.schedulemanager.services.TrialService;

@RequestMapping("/api")
@RestController
public class SchedulesRestController {

    @Autowired
    private TrialService trialService;

    @GetMapping("/trials/{sheduleId}")
    public @ResponseBody List<Trial> getTrialsByScheduleId(int sheduleId, Integer page, Integer pageSize) {

        return trialService.listTrialsByScheduleId(sheduleId, page, pageSize);
    }
}
