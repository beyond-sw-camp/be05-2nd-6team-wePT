package org.encore.apartment.community.domain.facility.data.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private Integer logId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "log_entry_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date logEntryTime;

	@Column(name = "log_exit_time", nullable = true)
	private Date logExitTime;

	@Column(name = "log_facility_id", nullable = false)
	private Integer logFacilityId;

	@Column(name = "log_user_id", nullable = false)
	private String logUserId;

	@Builder
	public Log(
		Integer logId,
		Date logEntryTime,
		Date logExitTime,
		Integer logFacilityId,
		String logUserId
	) {
		this.logId = logId;
		this.logEntryTime = logEntryTime;
		this.logExitTime = logExitTime;
		this.logFacilityId = logFacilityId;
		this.logUserId = logUserId;
	}

}

/*
log_id
log_entry_time
log_exit_time
log_facility_id
log_user_id
 */