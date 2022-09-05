package br.ufrn.residenciaimd.schedulemanager.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.residenciaimd.schedulemanager.entities.Judge;
import br.ufrn.residenciaimd.schedulemanager.entities.Part;
import br.ufrn.residenciaimd.schedulemanager.entities.Schedule;
import br.ufrn.residenciaimd.schedulemanager.entities.Trial;
import br.ufrn.residenciaimd.schedulemanager.services.JudgeService;
import br.ufrn.residenciaimd.schedulemanager.services.PartService;
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

    private final PartService partService;

    @GetMapping("/magistrado")
    public @ResponseBody List<Judge> getJudgeByName(
            @RequestParam(value = "nome") String name) {

        return judgeService.getJudgesByNameContaining(name);
    }

    @GetMapping("/parte")
    public @ResponseBody List<Part> getPartByName(
            @RequestParam(value = "nome") String name) {

        return partService.getPartsByNameContaining(name);
    }

    @GetMapping("/pautas")
    public @ResponseBody Schedule getScheduleByDate(
            @RequestParam(value = "data") Date date) {

        return scheduleService.getScheduleByDate(date);
    }

    @GetMapping("/pautas/relator")
    public @ResponseBody Schedule getScheduleByTrialRapporteur(
            @RequestParam(value = "id") Long judgeId) {
        Judge rapporteur = judgeService.getJudgeById(judgeId);
        return scheduleService.getScheduleByTrialRapporteur(rapporteur);
    }

    @GetMapping("/pautas/parte")
    public @ResponseBody List<Schedule> getScheduleByTrialPart(
            @RequestParam(value = "id") Long partId) {
        Part part = partService.getPartById(partId);
        return scheduleService.getScheduleByTrialPart(part);
    }

    @GetMapping("/processos/pauta")
    public @ResponseBody List<Trial> getTrialsByScheduleId(
            @RequestParam(value = "id") Long sheduleId) {

        return trialService.listTrialsByScheduleId(sheduleId);
    }
}
