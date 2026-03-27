-- 코드를 작성해주세요

select hd.dept_id, hd.dept_name_en, round(avg(he.sal), 0) as avg_sal
from hr_department hd
join hr_employees he on hd.dept_id = he.dept_id
group by hd.dept_id, hd.dept_name_en
order by avg_sal desc

/*

HR_DEPARTMENT와 HR_EMPLOYEES 테이블을 이용 부서별 평균 연봉 조회

부서ID: DEPT_ID
연봉: SAL

부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회

평균연봉은 소수점 첫째 자리에서 반올림, 컬럼명은 AVG_SAL
결과는 부서별 평균 연봉을 기준으로 내림차순 정렬
*/