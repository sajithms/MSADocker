package com.zcare.api.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zcare.api.customer.domain.CommunityAttendance;

public interface CommunityAttendanceRepository extends JpaRepository<CommunityAttendance, Integer> {
	
	@Query("SELECT c FROM CommunityAttendance c JOIN FETCH c.studentAttendanceList as s where c.attendanceDateString > :startDate and s.studentId = :studentId")
	List<CommunityAttendance> findCommunityAttendanceByStudentId(@Param("studentId")Integer studentId,@Param("startDate")String startDate);
	

}
