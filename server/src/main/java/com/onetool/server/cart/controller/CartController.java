package com.onetool.server.cart.controller;

import com.onetool.server.cart.service.CartService;
import com.onetool.server.global.auth.login.PrincipalDetails;
import com.onetool.server.global.exception.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * 도면 상세페이지에서 장바구니에 추가
     * @param principal
     * @param foodId
     * @return
     */
    @PostMapping("/api/cart/add/{foodId}")
    public ApiResponse<?> addBlueprintToCart(@AuthenticationPrincipal PrincipalDetails principal,
                                             @PathVariable Long foodId){
        return ApiResponse.onSuccess(cartService.addBlueprintToCart(principal.getContext(), foodId));
    }

    @GetMapping("/cart")
    public ApiResponse<?> showMyCart(@AuthenticationPrincipal PrincipalDetails principal){
        return ApiResponse.onSuccess(cartService.showCart(principal.getContext()));
    }

    @DeleteMapping("/api/cart/delete/{foodId}")
    public ApiResponse<?> deleteBlueprintInCart(@AuthenticationPrincipal PrincipalDetails principal,
                                                @PathVariable Long foodId){
        return ApiResponse.onSuccess(cartService.deleteBlueprintInCart(principal.getContext(), foodId));
    }
}
