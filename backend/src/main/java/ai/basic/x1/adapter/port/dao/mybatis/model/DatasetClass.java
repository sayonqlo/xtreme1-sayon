package ai.basic.x1.adapter.port.dao.mybatis.model;

import ai.basic.x1.entity.enums.ToolTypeEnum;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

/**
 * @author chenchao
 * @date 2022-03-11
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)
public class DatasetClass {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * The id of the inherited ontology
     */
    private Long ontologyId;

    /**
     * The id of the inherited class in the ontology
     */
    private Long classId;

    private Long datasetId;

    private String name;

    private String color;

    private ToolTypeEnum toolType;

    /**
     * Type configuration properties
     */
    @TableField(value = "tool_type_options", typeHandler = JacksonTypeHandler.class)
    private JSONObject toolTypeOptions;

    @TableField(value = "attributes", typeHandler = JacksonTypeHandler.class)
    private JSONArray attributes;

    /**
     * logic delete
     */
    @TableLogic
    private Boolean isDeleted;

    /**
     * create time
     */
    @TableField(fill = FieldFill.INSERT)
    private OffsetDateTime createdAt;

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * update time
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private OffsetDateTime updatedAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;
}