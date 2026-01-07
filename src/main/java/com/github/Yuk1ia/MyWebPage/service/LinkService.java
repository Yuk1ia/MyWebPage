package com.github.Yuk1ia.MyWebPage.service; // 【关键】包名必须与目录结构完全匹配

// 【关键】导入语句必须正确指向你项目中的实体和仓库类
import com.github.Yuk1ia.MyWebPage.entity.Link;
import com.github.Yuk1ia.MyWebPage.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 链接（Link）的业务逻辑服务类。
 * 负责处理与链接相关的所有业务操作。
 */
@Service // 此注解告知Spring这是一个服务层组件，并允许在其他地方注入它
public class LinkService {

    // 依赖注入：服务层需要数据访问层（Repository）来操作数据
    private final LinkRepository linkRepository;

    /**
     * 构造器注入（Spring推荐的依赖注入方式）。
     * @param linkRepository Spring会自动查找并注入LinkRepository的实例
     */
    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    /**
     * 获取所有链接的列表。
     * @return 包含所有链接的List集合
     */
    public List<Link> findAllLinks() {
        // 直接调用JpaRepository内置的findAll()方法
        return linkRepository.findAll();
    }

    /**
     * 根据ID查找一个特定的链接。
     * @param id 链接的主键ID
     * @return 如果找到，返回包含链接的Optional对象；否则返回空的Optional
     */
    public Optional<Link> findById(Long id) {
        return linkRepository.findById(id);
    }

    /**
     * 保存或更新一个链接。
     * @param link 需要保存或更新的链接对象
     * @return 保存后（包含可能由数据库生成的新ID）的链接对象
     */
    public Link save(Link link) {
        return linkRepository.save(link);
    }

    /**
     * 根据ID删除一个链接。
     * @param id 需要删除的链接的主键ID
     */
    public void deleteById(Long id) {
        linkRepository.deleteById(id);
    }
}