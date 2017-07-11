package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by RomanovaD on 11.07.2017.
 */
public class GithubTests {

    @Test
    public void testComits() throws IOException {
        Github github = new RtGithub("1104d74dc8b6bab840e1514ee27716ab3c0036e8");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("romawkad", "java_pft")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
