package com.cakmart.ecommerce.validation.groups;

import jakarta.validation.GroupSequence;

@GroupSequence({BasicCheck.class, FormatCheck.class, DatabaseCheck.class})
public interface ValidationSequence {
}
