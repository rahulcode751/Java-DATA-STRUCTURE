package ProblemsOnBfsAndDfs;

import java.util.*;

public class VII_WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return solve(beginWord,endWord,wordList);
    }
    public int solve(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String currentWord = pair.getKey();
            int level = pair.getValue();

            if (currentWord.equals(endWord)) {
                return level;
            }

            char[] wordChars = currentWord.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char originalChar = wordChars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) {
                        continue;
                    }

                    wordChars[i] = c;
                    String newWord = new String(wordChars);

                    if (wordSet.contains(newWord)) {
                        queue.offer(new Pair<>(newWord, level + 1));
                        wordSet.remove(newWord);
                    }
                }
                wordChars[i] = originalChar;
            }
        }

        return 0;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
