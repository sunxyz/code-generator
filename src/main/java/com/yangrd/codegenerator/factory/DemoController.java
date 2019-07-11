package com.yangrd.codegenerator.factory;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * DemoController
 *
 * @author yangrd
 * @date 2019/07/11
 */
@AllArgsConstructor

@RestController
@RequestMapping("/demo")
public class DemoController {

    private DemoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Demo demo){
        service.save(demo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody Demo demo){
        service.updateById(demo,id);
    }

    @GetMapping("/{id}")
    public Demo get(@PathVariable String id){
        return service.findOne(id);
    }

    @GetMapping
    public Page<Demo> findAll(Pageable pageable){
        return service.findAll(null,pageable);
    }
}
