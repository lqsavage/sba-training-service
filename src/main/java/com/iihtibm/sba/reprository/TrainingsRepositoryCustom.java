package com.iihtibm.sba.reprository;

import com.iihtibm.sba.model.TrainingDtls;

/**
 * @author savagelee
 */
public interface TrainingsRepositoryCustom {
	
	TrainingDtls findAvgRating(Long mentorId, Long skillId);

}
