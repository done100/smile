package com.stars.sea.work.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;


//目标表
@Table(name = "tg_target")
public class OpenKTgTarget {
        @Column(name = "id")
        private Long id;
        //目标名称
        @Column(name = "name")
        private String name;
        //分类ID
        @Column(name = "category_id")
        private Long categoryId;
        //课程大纲Id
        @Column(name = "syllabus_id")
        private Long syllabusId;
        //状态（0启用，1禁用）
        @Column(name = "enabled")
        private Integer enabled;
        //删除（0正常，1删除）
        @Column(name = "deleted")
        private Integer deleted;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
        @Column(name = "category_id")
        public Long getCategoryId() {
                return categoryId;
        }
        @Column(name = "category_id")
        public void setCategoryId(Long categoryId) {
                this.categoryId = categoryId;
        }
        @Column(name = "syllabus_id")
        public Long getSyllabusId() {
                return syllabusId;
        }

        public void setSyllabusId(Long syllabusId) {
                this.syllabusId = syllabusId;
        }

        public Integer getEnabled() {
                return enabled;
        }

        public void setEnabled(Integer enabled) {
                this.enabled = enabled;
        }

        public Integer getDeleted() {
                return deleted;
        }

        public void setDeleted(Integer deleted) {
                this.deleted = deleted;
        }
}
