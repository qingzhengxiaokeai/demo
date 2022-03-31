package com.scut.util;

import org.eclipse.jgit.api.Git;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class GitAdapter {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(GitAdapter.class);

    private final static String REF_HEADS = "refs/heads/";
    private final static String MASTER_BRANCH = "master";
    //远程仓库路径，用的就是.git
    private String remotePath;

    //本地仓库路径，包含了项目工程名projectname
    private String localPath;
    private String localGitPath;
    private Git git;
    private Repository repository;
    private Ref branchRef;
    public String branchName;
    //Git授权
    private static UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider;
    /**
     * 构造函数：没有传分支信息则默认拉取master代码
     * @param path
     * @param remotePath
     * @param localPath
     */
    public GitAdapter(String remotePath, String localPath){
        this(remotePath,localPath,MASTER_BRANCH);
    }

    public GitAdapter(String remotePath,String localPath,String branchName){
        this.remotePath=remotePath;
        this.localPath=localPath;
        this.branchName=branchName;
        localGitPath=this.localPath+"/.git";
        //鉴权账户密码可用自己github的账户密码，或者是设置token
        this.usernamePasswordCredentialsProvider=new UsernamePasswordCredentialsProvider("account","password");
    }

    /**
     * 使用Git时需要先初始化git
     * 默认初始化的时候会自动拉取 @branchName 的最新代码
     * @return
     */

}
