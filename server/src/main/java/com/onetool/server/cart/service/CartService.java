package com.onetool.server.cart.service;

import com.onetool.server.blueprint.Blueprint;
import com.onetool.server.diabetes.Diabetes;
import com.onetool.server.global.auth.MemberAuthContext;
import com.onetool.server.member.domain.Member;

import static com.onetool.server.cart.dto.CartResponse.CartItems;

public interface CartService {
    Object showCart(MemberAuthContext user);

    String addBlueprintToCart(MemberAuthContext user, Long blueprintId);

    String deleteBlueprintInCart(MemberAuthContext user, Long blueprintId);

    Member findMemberWithCart(Long id);

    Diabetes getDiabetes(Long blueprintId);
}