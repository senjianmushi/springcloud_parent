package com.crrchz.userserverprovider.model.domain;

import lombok.Data;

@Data
public class BaseMenu {
    private Integer id;
    private String menuUrl;
    private String menuSeq;
    private Integer menuParentId;
    private String menuName;
    private String menuIcon;
    private Integer menuOrder;
    private String isLeaf;
}