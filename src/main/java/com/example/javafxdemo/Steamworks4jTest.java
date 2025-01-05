package com.example.javafxdemo;

import com.codedisaster.steamworks.*;

/*
 * SteamAPI.loadLibraries("./libs");指定目录
 * 每当解锁一项或多项成就时为每项已解锁的成就调用 ISteamUserStats::SetAchievement 然后使用 ISteamUserStats::StoreStats立刻上传
 * 您的游戏将收到 ISteamUserStats::UserStatsStored_t 回调 并对每项已解锁成就外加一个 ISteamUserStats::UserAchievementStored_t回调
 *  Steam 游戏内叠加界面则会向用户显示一个通知面板
 * */
public class Steamworks4jTest {

    public static void main(String[] args) {
        try {
            SteamAPI.loadLibraries();
            if (!SteamAPI.init()) {
                System.out.println("Steamworks initialization error, e.g. Steam client not running");
                return;
            }
            System.out.println("success");
            MyAppUserStatsCallback callback = new MyAppUserStatsCallback();
            SteamUserStats userStats = new SteamUserStats(callback);
            if (userStats.requestCurrentStats()) {
                System.out.println("success requestCurrentStats");
                //成功的时候调用
                userStats.setAchievement("KNIGHT_DONE");
                System.out.println("KNIGHT_DONE " + userStats.storeStats());
            }
        } catch (SteamException e) {
            e.printStackTrace();
        }
    }

    public static final class MyAppUserStatsCallback implements SteamUserStatsCallback {

        /*
         * 当已从服务器收到指定用户的最新统计与成就时调用
         * gameId 游戏ID
         * steamIDUser 获取统计的用户
         * SteamResult 返回调用是否成功 如果用户无统计这将设置为ResultFail
         */
        @Override
        public void onUserStatsReceived(long gameId, SteamID steamIDUser, SteamResult result) {

        }

        /*
         * 用户统计存储请求的结果
         * gameId 这些统计针对的游戏ID
         * SteamResult 返回调用是否成功
         * */
        @Override
        public void onUserStatsStored(long gameId, SteamResult result) {

        }

        /*
         * 表示用户统计已卸载的回调
         * SteamID 统计已卸载的用户
         * */
        @Override
        public void onUserStatsUnloaded(SteamID steamIDUser) {

        }

        /*
         * 保存成就于服务器请求或表示进度调用的结果
         * 如果 CurProgress 与 MaxProgress 均为零则说明成就已完全解锁
         * gameId 此成就的游戏 ID
         *  isGroupAchievement 未使用
         * achievementName 成就名称
         * curProgress 成就的当前进度
         * maxProgress 解锁所需的总进度
         * */
        @Override
        public void onUserAchievementStored(long gameId, boolean isGroupAchievement, String achievementName, int curProgress, int maxProgress) {

        }

        /*
         * 找到一个排行榜时出现结果
         * leaderboard 查询到的排行榜的句柄如果未找到排行榜则为0
         * found 是否找到排行榜如果找到则为1 如果没找到则为0
         * */
        @Override
        public void onLeaderboardFindResult(SteamLeaderboardHandle leaderboard, boolean found) {

        }

        /*
         * 当排行榜的得分已下载并可获取时调用。调用后您必须使用 GetDownloadedLeaderboardEntry为各下载条目获取信息
         * leaderboard 这些条目所属的排行榜的句柄
         * entries 传入 GetDownloadedLeaderboardEntry 句柄以获取各下载条目的信息
         * numEntries 下载条目的数量
         * */
        @Override
        public void onLeaderboardScoresDownloaded(SteamLeaderboardHandle leaderboard, SteamLeaderboardEntriesHandle entries, int numEntries) {

        }

        /*
         * 结果表示已上传一个排行榜得分
         * success 如果调用成功则返回1 失败则返回0 发送的详情数量超过了 k_cLeaderboardDetailsMax 的规定 在Steamworks 网站的应用管理员页面中排行榜被设置为“受信任”且将只接受从 Steam Web API 发送的得分
         * leaderboard 此得分上传的排行榜的句柄
         * score 尝试设置的得分
         * scoreChanged 如果排行榜上的得分更改为 true 否则如果既有得分更高则为 false
         * globalRankNew 用户在此排行榜上的新全局排名
         * globalRankPrevious 用户在此排行榜上的上次全局排名 如果用户在排行榜上无既有条目则为0
         * */
        @Override
        public void onLeaderboardScoreUploaded(boolean success, SteamLeaderboardHandle leaderboard, int score, boolean scoreChanged, int globalRankNew, int globalRankPrevious) {

        }

        /*
         * 获得当前 AppId 的当前玩家数量
         * success 调用是否成功如果成功返回1 如果未成功则返回0
         * players 当前在玩的玩家数量
         * */
        @Override
        public void onNumberOfCurrentPlayersReceived(boolean success, int players) {

        }

        /*
        * 当从服务器获得全局统计时调用
        * gameId 这些全局统计所针对的游戏 ID
        * result 	请求的结果
                    k_EResultOK 表示成功
                    k_EResultInvalidState 表示统计尚未载入调用 RequestCurrentStats
                    k_EResultFail 表示远程调用失败
        * */
        @Override
        public void onGlobalStatsReceived(long gameId, SteamResult result) {

        }
    }

}
