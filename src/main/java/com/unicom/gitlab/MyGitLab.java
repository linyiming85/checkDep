package com.unicom.gitlab;

import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabProject;
import org.gitlab.api.models.GitlabSession;
import org.gitlab.api.models.GitlabUser;

import java.io.IOException;
import java.util.List;

/**
 * Created by linym on 2016/11/20.
 */
public class MyGitLab {
    private static String host="http://172.16.54.135:10080";
    private static String username="linym";
    private static String password="linym1985";
    private static GitlabAPI gitlabAPI;
    private static GitlabSession session;
    public MyGitLab(String host, String username, String password) throws IOException {
        this.session=GitlabAPI.connect(host,username,password);
        this.gitlabAPI=GitlabAPI.connect(host,session.getPrivateToken());
    }


    public static void main(String[] strs) throws IOException {
        MyGitLab myGitLab=new MyGitLab(host,username,password);
        List<GitlabUser> gitlabUserList=gitlabAPI.getUsers();
        for(GitlabUser user:gitlabUserList){
            System.out.println(user.getName());
        }
        List<GitlabProject> projectList=gitlabAPI.getProjects();
        for (GitlabProject project:projectList){
            System.out.println("project:"+project.getHttpUrl());

        }

    }
}
