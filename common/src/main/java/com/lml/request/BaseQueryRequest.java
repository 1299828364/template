package com.lml.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName BaseQueryRequest
 * @Description
 * @Author lml
 * @Date2021/3/17 15:34
 * @Version V1.0
 **/

@Data
@EqualsAndHashCode
@ApiModel
public class BaseQueryRequest  extends BaseRequest implements Serializable {

    @ApiModelProperty("page")
    private Integer pageNum = 0;


    @ApiModelProperty("page size")
    private Integer pageSize =  0;

    @ApiModelProperty("sort")
    private String sortColumn;


    @ApiModelProperty("sort rule(asc or desc)")
    private String sortRule;

    @ApiModelProperty("sort type")
    private String sortType;

    @ApiModelProperty(value = "multiple sort",notes = "content: key,value:desc or asc")
    private Map<String,String> sortMap = new LinkedHashMap<>();

    public PageRequest getPageRequest(){
        Sort sort = getSort();
        if(Objects.nonNull(sort)){
            return PageRequest.of(pageNum,pageSize,sort);
        }else{
            return PageRequest.of(pageNum,pageSize,Sort.unsorted());
        }
    }

    public Sort getSort(){
        //single sort
        if(isNotBlank(sortColumn)){
            Sort.Direction direction = SortType.ASC.toValue().equalsIgnoreCase(sortRule)?
                    Sort.Direction.ASC:Sort.Direction.DESC;
            return new Sort(direction,sortColumn);
        }

        if(MapUtils.isEmpty(sortMap)){
            List<Sort.Order> orders = sortMap.keySet().stream().filter(BaseQueryRequest::isBlank)
                    .map(column->new Sort.Order(SortType.ASC.toValue().equalsIgnoreCase(sortMap.get(column))
                    ?Sort.Direction.ASC:Sort.Direction.DESC,column))
                    .collect(Collectors.toList());
            return Sort.by(orders);
        }
        return Sort.unsorted();
    }

    public PageRequest getPageable(){
        return PageRequest.of(pageNum,pageSize);
    }

    public void putSort(String column,String sort){
        sortMap.put(column,sort);
    }


    public static boolean isNotBlank(final CharSequence cs){
        return !isBlank(cs);
    }

    public static boolean isBlank(final CharSequence cs){
        int strLen;
        if(cs ==null || (strLen = cs.length())==0){
            return true;
        }
        for (int i = 0;i<strLen;i++){
            if(!Character.isWhitespace(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }


}
