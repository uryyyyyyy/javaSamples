package com.github.uryyyyyyy.javaSamples.git;

import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.util.List;

public class JgitSample {
    public static void main(String[] args) throws Exception {
        // ローカルリポジトリの指定など
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("/ika/" + Constants.DOT_GIT)).readEnvironment().findGitDir().build();

        // Git オブジェクト作成 (このオブジェクトを操作していろいろする)
        Git git = new Git(repository);

        // ブランチの切り替え(リモートにあるやつ)
        try {
            // 初めてリモートリポジトリを checkout する場合
            git.checkout().setCreateBranch(true).setName("ブランチ名")
                    .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.SET_UPSTREAM)
                    .setStartPoint("リポジトリ名" + "ブランチ名").call(); // origin/ブランチ名 みたいに設定する

        } catch (RefAlreadyExistsException e) {
            // 2回目以降(checkout 済みだと上記例外が投げられるっぽいので)
            try {
                git.checkout().setName("ブランチ名").call();
                git.pull().call();
            } catch (GitAPIException e1) {
                throw new RuntimeException(e);
            }
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }

        // ブランチ名の一覧取得(Ref の getName()で「refs/remotes/origin/master」のように取得できる)
        List<Ref> branchList = git.branchList().setListMode(ListBranchCommand.ListMode.ALL).call();
    }
}