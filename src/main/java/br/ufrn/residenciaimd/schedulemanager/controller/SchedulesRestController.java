package br.ufrn.residenciaimd.schedulemanager.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;
import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;
import br.ufrn.residenciaimd.schedulemanager.entities.Trial;
import br.ufrn.residenciaimd.schedulemanager.services.JudgeService;
import br.ufrn.residenciaimd.schedulemanager.services.ScheduleService;
import br.ufrn.residenciaimd.schedulemanager.services.TrialService;
import lombok.AllArgsConstructor;

@RequestMapping(path = "/api")
@RestController
@AllArgsConstructor
public class SchedulesRestController {

    private final TrialService trialService;

    private final ScheduleService scheduleService;

    private final JudgeService judgeService;

    @GetMapping("/trials")
    public @ResponseBody List<Trial> getTrialsByScheduleId(
            @RequestParam(value = "shedule_id") Long sheduleId) {

        return trialService.listTrialsByScheduleId(sheduleId);
    }

    @GetMapping("/judge")
    public @ResponseBody List<Judge> getJudgeByName(
            @RequestParam(value = "name") String name) {

        return judgeService.getJudgesByNameContaining(name);
    }

    @GetMapping("/schedule")
    public @ResponseBody Schedule getScheduleByDate(
            @RequestParam(value = "date") Date date) {

        return scheduleService.getScheduleByDate(date);
    }
}
