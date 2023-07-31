package com.best.kwan.vo;

import com.best.kwan.Entity.TrainerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerVO {

    private Long trainerId;
    private String name;
    private String email;
    private String pwd;
    private String gender;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private List<String> trainerImage;
    private List<String> trainerHistory;

    public TrainerVO(TrainerEntity trainerEntity) {
        this.trainerId = trainerEntity.getTrainerId();
        this.name = trainerEntity.getName();
        this.email = trainerEntity.getEmail();
        this.pwd = trainerEntity.getPwd();
        this.gender = trainerEntity.getGender();
        this.createAt = trainerEntity.getCreateAt();
        this.updateAt = trainerEntity.getUpdateAt();
        this.trainerImage = trainerEntity.getTrainerImageEntities().stream().map((trainerImageEntity) ->
        {
            return trainerImageEntity.getPath();
        }).collect(Collectors.toList());
        this.trainerHistory = trainerEntity.getTrainerHistoryEntities().stream()
                .map(historyEntity -> {
                    return historyEntity.getHistory();
                })
                .collect(Collectors.toList());


    }
}
