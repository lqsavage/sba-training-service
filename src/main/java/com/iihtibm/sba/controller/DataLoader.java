package com.iihtibm.sba.controller;

import com.iihtibm.sba.entity.Training;
import com.iihtibm.sba.reprository.TrainingsRepository;
import com.iihtibm.sba.service.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author savagelee
 */
@Component
public class DataLoader implements ApplicationRunner {

	private static Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private TrainingsRepository trainingRepository;

	@Autowired
	private SequenceGeneratorService sequencegenerator;

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		Training newTraining = new Training();
		newTraining.setId(sequencegenerator.generateSequence(Training.SEQUENCE_NAME));

		newTraining.setStartDate("2019-11-11");
		newTraining.setEndDate("2019-12-11");
		newTraining.setStartTime("09:00:00");
		newTraining.setEndTime("11:00:00");
		newTraining.setMentorId(8L);
		newTraining.setSkillId(1L);
		newTraining.setPersistent(true);
		trainingRepository.save(newTraining);
		logger.info("Java training inserted");

		newTraining.setId(sequencegenerator.generateSequence(Training.SEQUENCE_NAME));
		newTraining.setStartDate("2019-12-12");
		newTraining.setEndDate("2020-01-12");
		newTraining.setStartTime("09:00:00");
		newTraining.setEndTime("11:00:00");
		newTraining.setMentorId(8L);
		newTraining.setSkillId(2L);
		newTraining.setPersistent(true);
		trainingRepository.save(newTraining);
		logger.info("Python training inserted");

	}
}
