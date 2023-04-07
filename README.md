# coupon
coupon CRUD

### JPA
> - @EntityListene
>   - 이벤트 발생 시 콜백을 처리하고 코드를 실행.
>   - persist(insert) / remove / update
>   - Pre(전) / Post(후)
>   - PostLoad - select 후 실행.
> - @MappedSuperclass
>   - 엔티티가 아니다 -> entityManager.find()나 JPQL 을 사용할 수 없다.
>   - 직접 생성해서 사용할 일이 없으므로 추상클래스 사용추천.
>   - 테이블과 관계 없고 단순히 엔티티가 공통으로 사용하는 매핑 정보를 모으는 역할이다.
> - AuditingEntityListener
>   - 스프링에서 구현해놓은 EntityListner
>   - 사용을 위해서 어플리케이션 구동 클래스에  @EnableJpaAuditing필요
>   - @CreatedBy(작성자) , @CreatedDate(작성일) @LastModifiedDate(수정일) @LastModifiedBy(수정자) 등 사용가능.


### Reference
- https://ugo04.tistory.com/102