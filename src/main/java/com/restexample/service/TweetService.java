package com.restexample.service;

import com.restexample.persistence.entity.TweetEntity;
import com.restexample.persistence.entity.UserEntity;
import com.restexample.persistence.repository.TweetRepository;
import com.restexample.persistence.repository.UserRepository;
import com.saha.model.Tweet;
import com.saha.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TweetService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private DozerBeanMapper mapper;

    public Collection<Tweet> userTweets(Long userId) {
        Collection<TweetEntity> tweets = tweetRepository.findTop5ByUserEntityIdOrderById(userId);
        return convertToModel(tweets);
        //Collection<TweetEntity> tweets = tweetRepository.findByUserEntityId(userId);
    }

    public Collection<Tweet> tweets(Integer page, Integer size) {

        Page<TweetEntity> tweetEntities = tweetRepository
                .findAll(new PageRequest(page, size));
        return convertToModel(tweetEntities.getContent());

    }

    public User users(Long id) {
        return null;
    }

    public List<Tweet> save(TweetEntity tweet, Long userId) {
        UserEntity userEntity = userRepository.findOne(userId);
        userEntity.getTweets().add(tweet);
        tweet.setUserEntity(userEntity); // Tweet te userEntity i setlemek lazım
        userEntity = userRepository.save(userEntity);
        return convertToModel(userEntity.getTweets());

    }

    public Boolean delete(Long id) {
        return null;
    }

    public User update(Long id, User user) {
        return null;
    }

    private List<Tweet> convertToModel(Collection<TweetEntity> tweetEntities) {
        List<Tweet> tweetList = new ArrayList<Tweet>();
        for (TweetEntity tweetEntity : tweetEntities) {
            Tweet eachTweet = new Tweet();
            mapper.map(tweetEntity, eachTweet);
            tweetList.add(eachTweet);
        }
        return tweetList;
    }

}
