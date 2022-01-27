package com.example.demo.application.rest.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageInfo {
    int currentPage;
    long totalCount;
    int totalPages;
}
