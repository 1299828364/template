package com.lml.model.request;

import com.lml.model.User;
import com.lml.request.BaseQueryRequest;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserQueryRequest
 * @Description
 * @Author lml
 * @Date2021/3/18 9:49
 * @Version V1.0
 **/

@Data
public class UserQueryRequest extends BaseQueryRequest {
    private Long userId;
    private String userName;
    private Integer state;
    private Date queryStartTime;
    private Date queryEndTime;
    private Integer tempVipFlag;
    private Integer delFlag;
    private Integer type;


    //jpa 高级筛选
    public Specification<User> getWhereCriteria(){
        return (root,cquery,cbuild)->{
            List<Predicate> predicates = new ArrayList<>();
            if(this.userId!=null){
                predicates.add(cbuild.equal(root.get("userId"),this.userId));
            }if(this.userName!=null){
                predicates.add(cbuild.like(root.get("userName"),"%"+this.userId+"%"));
            }if(this.state!=null){
                predicates.add(cbuild.equal(root.get("state"),this.userId));
            }if(this.tempVipFlag!=null){
                predicates.add(cbuild.equal(root.get("tempVipFlag"),this.userId));
            }if(this.delFlag!=null){
                predicates.add(cbuild.equal(root.get("delFlag"),this.userId));
            }if(this.type!=null){
                predicates.add(cbuild.equal(root.get("type"),this.userId));
            }if(this.delFlag!=null){
                predicates.add(cbuild.equal(root.get("delFlag"),this.userId));
            }if(this.queryStartTime!=null){
                predicates.add(cbuild.greaterThanOrEqualTo(root.get("createTime"),this.queryStartTime));
            }if(this.queryEndTime!=null){
                predicates.add(cbuild.lessThanOrEqualTo(root.get("createTime"),this.queryEndTime));
            }
            predicates.add(cbuild.equal(root.get("deFlag"),0));

            Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);
            return p.length ==0?null: p.length==1?p[0]:cbuild.and(p);
        };
    }
}
