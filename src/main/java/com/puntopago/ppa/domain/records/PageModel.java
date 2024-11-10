package com.puntopago.ppa.domain.records;

import java.math.BigInteger;

public record PageModel<T>(T data, BigInteger total) {}
