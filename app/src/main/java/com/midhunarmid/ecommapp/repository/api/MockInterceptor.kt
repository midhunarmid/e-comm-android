package com.midhunarmid.ecommapp.repository.api

import com.midhunarmid.ecommapp.BuildConfig
import okhttp3.*

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.endsWith("/b/5fdd9ed3e3d1c53225093bbb/2") -> getListOfReposBeingStarredJson
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                    responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                    "bound to be used only with DEBUG mode")
        }
    }

}

const val getListOfReposBeingStarredJson = """
{
	"carousel": {
		"order": 1,
		"items": [{
				"image": "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/24/6f060090-1e7b-44b4-be71-83c342c5ab7c1600965593736-Pantaloons-desktop-banner.jpg",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/24/6f060090-1e7b-44b4-be71-83c342c5ab7c1600965593736-Pantaloons-desktop-banner.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/25/82188d2f-6ef6-4040-aeaf-4eb14fcecccb1600976836176-Pre-buzz-main_DK_Banner.jpg",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/25/82188d2f-6ef6-4040-aeaf-4eb14fcecccb1600976836176-Pre-buzz-main_DK_Banner.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/24/42c8bc41-3a3a-461a-ba10-618017079a591600956475380-smashbox_desktop.jpg",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2020/9/24/42c8bc41-3a3a-461a-ba10-618017079a591600956475380-smashbox_desktop.jpg",
					"params": ""
				}
			},
			{
				"image": "https://images.bewakoof.com/uploads/grid/app/feedback-survey-bewakoof-desktop-1588604341.gif",
				"click_action": {
					"open": "URL",
					"target": "https://images.bewakoof.com/uploads/grid/app/feedback-survey-bewakoof-desktop-1588604341.gif",
					"params": ""
				}
			},
			{
				"image": "https://img.thesouledstore.com/public/theSoul/uploads/slider/20200906111658.jpg",
				"click_action": {
					"open": "URL",
					"target": "https://img.thesouledstore.com/public/theSoul/uploads/slider/20200906111658.jpg",
					"params": ""
				}
			},
			{
				"image": "https://images.bewakoof.com/uploads/grid/app/bewakoof-tribe-offer-discount-online-shopping-deskto-bannr-1599219437.jpg",
				"click_action": {
					"open": "URL",
					"target": "https://images.bewakoof.com/uploads/grid/app/bewakoof-tribe-offer-discount-online-shopping-deskto-bannr-1599219437.jpg",
					"params": ""
				}
			}
		]
	},
	"products": {
		"order": 2,
		"items": [{
				"image": "https://img.thesouledstore.com/public/theSoul/uploads/catalog/product/1586353119_7100176.jpg",
				"title": "D Trimmers",
				"subtitle": "Min 50% off",
				"click_action": {
					"open": "URL",
					"target": "https://img.thesouledstore.com/public/theSoul/uploads/catalog/product/1586353119_7100176.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/productimage/2019/9/29/68f1b791-7b82-4b9c-81a6-71eb4e1657f91569717917068-4.jpg",
				"title": "D Shirts",
				"subtitle": "Min 40% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/productimage/2019/9/29/68f1b791-7b82-4b9c-81a6-71eb4e1657f91569717917068-4.jpg",
					"params": ""
				}
			},
			{
				"image": "https://images.bewakoof.com/t540/save-our-home-half-sleeve-t-shirt-men-s-printed-t-shirts-276161-1594353909.jpg",
				"title": "D Jackets",
				"subtitle": "Min 30% off",
				"click_action": {
					"open": "URL",
					"target": "https://images.bewakoof.com/t540/save-our-home-half-sleeve-t-shirt-men-s-printed-t-shirts-276161-1594353909.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/9982787/2019/10/23/7d437d1a-5e21-4efd-9854-6d17a43dcf3e1571818952031-Levis-Men-Shirts-6101571818949572-1.jpg",
				"title": "D Jeans",
				"subtitle": "Min 70% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/9982787/2019/10/23/7d437d1a-5e21-4efd-9854-6d17a43dcf3e1571818952031-Levis-Men-Shirts-6101571818949572-1.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/1700944/2019/6/8/972c9498-3a37-4d5d-976c-4493b4d5c0021559989322793-HRX-by-Hrithik-Roshan-Men-Yellow-Printed-Round-Neck-T-Shirt--1.jpg",
				"title": "D Trimmers",
				"subtitle": "Min 50% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/1700944/2019/6/8/972c9498-3a37-4d5d-976c-4493b4d5c0021559989322793-HRX-by-Hrithik-Roshan-Men-Yellow-Printed-Round-Neck-T-Shirt--1.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/8799255/2019/4/17/1d5ad0d4-8ab5-4260-86aa-237df01220741555496849145-HERENOW-Women-Sea-Green--White-Printed-Straight-Kurta-561155-1.jpg",
				"title": "D Trimmers",
				"subtitle": "Min 50% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/8799255/2019/4/17/1d5ad0d4-8ab5-4260-86aa-237df01220741555496849145-HERENOW-Women-Sea-Green--White-Printed-Straight-Kurta-561155-1.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10856160/2019/11/5/f0172470-408a-4b8b-a1e5-045bd98a5f8b1572938035104-SASSAFRAS-Women-Dresses-9581572938032856-1.jpg",
				"title": "D Trimmers",
				"subtitle": "Min 50% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/10856160/2019/11/5/f0172470-408a-4b8b-a1e5-045bd98a5f8b1572938035104-SASSAFRAS-Women-Dresses-9581572938032856-1.jpg",
					"params": ""
				}
			},
			{
				"image": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/productimage/2019/11/28/cd191469-0b3b-470c-8365-20cc4c37556d1574893593957-1.jpg",
				"title": "D Trimmers",
				"subtitle": "Min 50% off",
				"click_action": {
					"open": "URL",
					"target": "https://assets.myntassets.com/h_1440,q_90,w_1080/v1/assets/images/productimage/2019/11/28/cd191469-0b3b-470c-8365-20cc4c37556d1574893593957-1.jpg",
					"params": ""
				}
			}
		]
	},
	"banner": {
		"order": 3,
		"items": ["https://images.bewakoof.com/uploads/grid/app/bewakoof-cricket-carnival-ipl-online-fashion-shopping-desktop-1-1600148516.jpg"]
	}
}
"""