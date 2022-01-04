package com.cdnu.baikun.service.impl;

import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.domain.Resources;
import com.cdnu.baikun.dto.CoverVo;
import com.cdnu.baikun.service.CoverService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 白坤 
 * @date 2021/8/10
 */
@Service
public class CoverServiceImpl implements CoverService {
    @Override
    public List<CoverVo> coverVoList(List<Resources> resources, List<News> news, List<Image> images) {
        if (images==null) return null;
        
        List<CoverVo> coverVoList=new ArrayList<>();

        if (resources==null){
            news.forEach(news1 -> {
                List<Image> list = images.parallelStream().filter(image -> image.getNewsId() == news1.getNewsId()).collect(Collectors.toList());
                CoverVo coverVo;
                if (list.size() > 0){
                    coverVo=new CoverVo(list.get(0).getImgSrc(),news1.getNewsTitle(),news1.getNewsContent(),news1.getNewsId(),"news");
                }else {
                    coverVo=new CoverVo(null,news1.getNewsTitle(),news1.getNewsContent(),news1.getNewsId(),"news");
                }
                coverVoList.add(coverVo);
            });
        }else if (news==null){
            resources.forEach(resource -> {
                List<Image> list = images.parallelStream().filter(image -> image.getResourceId() == resource.getResourcesId()).collect(Collectors.toList());
                CoverVo coverVo;
                list.stream().map(Image::getImgSrc).forEach(System.out::println);
                if (list.size() > 0){
                    coverVo=new CoverVo(list.get(0).getImgSrc(),resource.getResourcesTitle(),resource.getResourcesContent(),resource.getResourcesId(),"resource");
                }else {
                    coverVo=new CoverVo(null,resource.getResourcesTitle(),resource.getResourcesContent(),resource.getResourcesId(),"resource");
                }
                coverVoList.add(coverVo);
            });
        }
        return coverVoList;
    }

    @Override
    public CoverVo cover(Resources resources, News news, Image image) {
        if (resources==null){
            if (image==null) return new CoverVo(null,news.getNewsTitle());
           return new CoverVo(image.getImgSrc(),news.getNewsTitle(),news.getNewsContent());
        }else if (news==null){
            if (image==null) return new CoverVo(null,resources.getResourcesTitle());
            return new CoverVo(image.getImgSrc(),resources.getResourcesTitle(),resources.getResourcesContent());
        }else {
            return null;
        }
    }
}
